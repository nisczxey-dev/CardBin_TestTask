package com.nisczxey.domain

import com.nisczxey.domain.model.CardModel
import com.nisczxey.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface BinCardRepository {

    suspend fun getCardInfoByBin(bin: String): Result

    fun getCardsHistory(): Flow<List<CardModel>>

}