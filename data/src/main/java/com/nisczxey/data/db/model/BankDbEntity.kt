package com.nisczxey.data.db.model

import androidx.room.ColumnInfo

data class BankDbEntity(
    @ColumnInfo(name = "bank_name")
    val bankName: String?,
    @ColumnInfo(name = "bank_url")
    val bankUrl: String?,
    @ColumnInfo(name = "bank_phone")
    val bankPhone: String?,
)
