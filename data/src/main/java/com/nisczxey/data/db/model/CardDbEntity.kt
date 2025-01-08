package com.nisczxey.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class CardDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "scheme")
    val scheme: String,
    @ColumnInfo("type")
    val type: String,
    @ColumnInfo("brand")
    val brand: String,
    @ColumnInfo("country")
    val country: String,
    @Embedded
    val bank: BankDbEntity,
    @ColumnInfo("saved_date")
    val savedDate: String
)