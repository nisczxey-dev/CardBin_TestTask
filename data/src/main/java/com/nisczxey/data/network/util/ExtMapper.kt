package com.nisczxey.data.network.util

import com.nisczxey.data.network.model.Bank
import com.nisczxey.data.network.model.CardCloudModel
import com.nisczxey.domain.model.BankModel
import com.nisczxey.domain.model.CardModel

fun Bank.toModel(): BankModel {
    return BankModel(
        name, url, phone
    )
}

fun CardCloudModel.toModel(): CardModel {
    return CardModel(
        scheme = scheme,
        type = type,
        brand = brand,
        country = country.name + country.emoji,
        bank = bank.toModel()
    )
}