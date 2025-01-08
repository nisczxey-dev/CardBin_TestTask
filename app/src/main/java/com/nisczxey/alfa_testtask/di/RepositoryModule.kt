package com.nisczxey.alfa_testtask.di

import com.nisczxey.data.BinCardRepositoryImpl
import com.nisczxey.data.db.HistoryDatabase
import com.nisczxey.data.network.BinCardService
import com.nisczxey.domain.BinCardRepository
import com.nisczxey.domain.common.AppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(
        api: BinCardService,
        db: HistoryDatabase,
        appDispatchers: AppDispatchers
    ): BinCardRepository {
        return BinCardRepositoryImpl(api, db, appDispatchers)
    }
}