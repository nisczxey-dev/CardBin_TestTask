package com.nisczxey.presentation.screens.util

import com.nisczxey.domain.model.BankModel
import com.nisczxey.domain.model.CardModel
import com.nisczxey.presentation.screens.models.BankUiModel
import com.nisczxey.presentation.screens.models.CardCustomUiModel

fun BankModel.toUiModel(): BankUiModel {
    return BankUiModel(
        name = name,
        siteUrl = url,
        number = phone
    )
}

fun CardModel.toUiModel(): CardCustomUiModel {
    return CardCustomUiModel(
        scheme = scheme,
        brand = brand,
        type = type,
        country = country,
        bank = bank.toUiModel(),
        savedDate = savedTIme
    )
}