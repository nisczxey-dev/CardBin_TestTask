package com.nisczxey.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nisczxey.data.db.model.CardDbEntity

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history_table")
    fun getHistory(): List<CardDbEntity>

    @Insert
    fun saveToHistory(entity: CardDbEntity)

}