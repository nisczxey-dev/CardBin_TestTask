package com.nisczxey.alfa_testtask.di

import com.nisczxey.domain.common.AppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideAppDispatchers(): AppDispatchers {
        return AppDispatchers()
    }
}