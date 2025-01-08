package com.nisczxey.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nisczxey.domain.BinCardRepository
import com.nisczxey.domain.common.AppDispatchers
import com.nisczxey.domain.model.Result
import com.nisczxey.presentation.screens.main.state.CardUiState
import com.nisczxey.presentation.screens.util.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: BinCardRepository,
    private val appDispatchers: AppDispatchers
) : ViewModel() {

    private val _uiState: MutableLiveData<CardUiState> = MutableLiveData()
    val uiState: LiveData<CardUiState>
        get() = _uiState


    fun getCardInfo(bin: String) {
        checkBin(bin)
        if (_uiState.value?.isNeedToShowError == true) return
        viewModelScope.launch(appDispatchers.io) {
            val result = repository.getCardInfoByBin(bin)

            withContext(appDispatchers.main) {
                processResult(result)
            }
        }
    }

    fun errorShown(isErrorShown: Boolean) {
        if (isErrorShown) {
            _uiState.value = _uiState.value?.copy(isNeedToShowError = false)
        }
    }

    private fun checkBin(bin: String) {
        if (bin.length < 6) {
            _uiState.value = CardUiState(
                isNeedToShowError = true,
                error = ERROR_LESS_LETTERS,
                data = null
            )
            return
        }
    }

    private fun processResult(result: Result) {
        when (result) {
            is Result.Success -> {
                _uiState.value = CardUiState(
                    isNeedToShowError = false,
                    data = result.data.toUiModel()
                )
            }

            is Result.Error -> {
                _uiState.value = CardUiState(
                    true,
                    result.error,
                    null
                )
            }
        }
    }

    private companion object {
        val ERROR_LESS_LETTERS = "Must Be 6 to 8 digits"
    }

}