package com.nisczxey.domain.model

data class CardModel(
    val scheme: String,
    val type: String,
    val brand: String,
    val country: String,
    val bank: BankModel,
    val savedTIme: String? = null
)
