package com.nisczxey.alfa_testtask.di

import android.content.Context
import com.nisczxey.data.db.HistoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    fun provideDb(@ApplicationContext appContext: Context): HistoryDatabase {
        return HistoryDatabase.create(appContext)
    }
}