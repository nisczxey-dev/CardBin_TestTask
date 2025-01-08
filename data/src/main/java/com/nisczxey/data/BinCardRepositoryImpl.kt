package com.nisczxey.data

import android.util.Log
import com.nisczxey.data.db.HistoryDatabase
import com.nisczxey.data.db.util.toDbEntity
import com.nisczxey.data.db.util.toModel
import com.nisczxey.data.network.BinCardService
import com.nisczxey.data.network.util.toModel
import com.nisczxey.data.time.DateTimeManager
import com.nisczxey.domain.BinCardRepository
import com.nisczxey.domain.common.AppDispatchers
import com.nisczxey.domain.model.CardModel
import com.nisczxey.domain.model.Result
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class BinCardRepositoryImpl @Inject constructor(
    private val apiService: BinCardService,
    private val db: HistoryDatabase,
    private val appDispatchers: AppDispatchers
) : BinCardRepository {

    override suspend fun getCardInfoByBin(bin: String): Result {
        return try {
            val card = apiService.getCard(bin = bin).toModel()
            saveCardToHistoryDb(card)
            Result.Success(card)
        } catch (e: HttpException) {
            parseHttpErrors(e)
        } catch (e: NullPointerException) {
            Log.e("not_found", "$e")
            Result.Error(NOT_FOUND)
        } catch (e: Exception) {
            Log.d("error_exception", e.toString())
            Result.Error(error = e.toString())
        }
    }

    override fun getCardsHistory(): Flow<List<CardModel>> = flow {
        val data = db.getDao().getHistory().map {
            it.toModel()
        }
        emit(data)
    }

    private suspend fun saveCardToHistoryDb(card: CardModel) = coroutineScope {
        launch(appDispatchers.io) {
            val dateTimeManager = DateTimeManager()
            Log.d("timeM", dateTimeManager.getCurrentTime())
            db.getDao().saveToHistory(card.toDbEntity(dateTimeManager.getCurrentTime()))
        }
    }

    private fun parseHttpErrors(e: HttpException): Result {
        return if (e.code() == 429) {
            Result.Error(error = HTTP_ERROR + e.code() + MUCH_REQUESTS)
        } else {
            Result.Error(error = HTTP_ERROR + e.code())
        }
    }

    private companion object {
        const val HTTP_ERROR = "HTTP error: "
        const val MUCH_REQUESTS = "too much requests"
        const val NOT_FOUND = "Not Found"
    }

}