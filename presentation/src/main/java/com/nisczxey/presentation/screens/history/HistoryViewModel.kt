package com.nisczxey.presentation.screens.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nisczxey.domain.BinCardRepository
import com.nisczxey.domain.common.AppDispatchers
import com.nisczxey.domain.model.CardModel
import com.nisczxey.presentation.screens.history.state.HistoryUiState
import com.nisczxey.presentation.screens.util.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: BinCardRepository,
    private val appDispatchers: AppDispatchers
) : ViewModel() {
    private val _uiState: MutableLiveData<HistoryUiState> = MutableLiveData()
    val uiState: LiveData<HistoryUiState>
        get() = _uiState

    init {
        startGettingHistory()
    }

    private fun startGettingHistory() {
        viewModelScope.launch {
            repository.getCardsHistory()
                .flowOn(appDispatchers.io)
                .catch { e ->
                    errorState(e.toString())
                }
                .collect {
                    successState(it)
                }
        }
    }

    private fun errorState(e: String) {
        _uiState.postValue(
            HistoryUiState(
                isNeedToShowError = true,
                error = e,
                data = null
            )
        )
    }

    private fun successState(list: List<CardModel>) {
        _uiState.postValue(
            HistoryUiState(
                isNeedToShowError = false,
                data = list.map { it.toUiModel() })
        )
    }

    fun errorShown() {
        _uiState.value = _uiState.value?.copy(isNeedToShowError = false)
    }

}