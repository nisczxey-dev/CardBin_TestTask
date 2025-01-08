package com.nisczxey.presentation.screens.main.state

import com.nisczxey.presentation.screens.models.CardCustomUiModel

data class CardUiState(
    val isNeedToShowError: Boolean,
    val error: String? = null,
    val data: CardCustomUiModel?
)
