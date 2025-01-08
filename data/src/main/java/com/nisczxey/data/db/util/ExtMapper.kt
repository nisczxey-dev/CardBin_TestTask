package com.nisczxey.data.db.util

import com.nisczxey.data.db.model.BankDbEntity
import com.nisczxey.data.db.model.CardDbEntity
import com.nisczxey.domain.model.BankModel
import com.nisczxey.domain.model.CardModel

fun BankModel.toDbEntity(): BankDbEntity {
    return BankDbEntity(bankName = name, bankUrl = url, bankPhone = phone)
}

fun CardModel.toDbEntity(creationDate: String): CardDbEntity {
    return CardDbEntity(
        scheme = scheme,
        type = type,
        brand = brand,
        country = country,
        bank = bank.toDbEntity(),
        savedDate = creationDate
    )
}

fun BankDbEntity.toModel(): BankModel {
    return BankModel(
        name = bankName,
        url = bankUrl,
        phone = bankPhone
    )
}

fun CardDbEntity.toModel(): CardModel {
    return CardModel(
        scheme = scheme,
        type = type,
        brand = brand,
        country = country,
        bank = bank.toModel(),
        savedTIme = savedDate
    )
}