package com.nisczxey.alfa_testtask.di

import com.nisczxey.data.network.BinCardService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideService(): BinCardService {
        return BinCardService.create()
    }
}