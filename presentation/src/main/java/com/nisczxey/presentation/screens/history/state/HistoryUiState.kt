package com.nisczxey.presentation.screens.history.state

import com.nisczxey.presentation.screens.models.CardCustomUiModel

data class HistoryUiState(
    val isNeedToShowError: Boolean,
    val error: String? = null,
    val data: List<CardCustomUiModel>? = emptyList()
)
