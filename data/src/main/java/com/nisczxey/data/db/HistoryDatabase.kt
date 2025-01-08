package com.nisczxey.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nisczxey.data.db.model.CardDbEntity

@Database(entities = [CardDbEntity::class], version = 1)
abstract class HistoryDatabase() : RoomDatabase() {
    abstract fun getDao(): HistoryDao

    companion object {
        const val NAME = "history_db"

        fun create(context: Context): HistoryDatabase {
            return Room.databaseBuilder(context = context, HistoryDatabase::class.java, NAME)
                .build()
        }
    }
}