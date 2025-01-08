package com.nisczxey.presentation.screens.models

data class CardCustomUiModel(
    val scheme: String,
    val brand: String,
    val type: String,
    val country: String,
    val bank: BankUiModel,
    val savedDate: String? = null
)