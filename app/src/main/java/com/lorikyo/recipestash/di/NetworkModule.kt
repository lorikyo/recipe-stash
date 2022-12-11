package com.lorikyo.recipestash.di

import com.lorikyo.recipestash.api.MealDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideMealDBService(): MealDBService {
        return MealDBService.create()
    }
}