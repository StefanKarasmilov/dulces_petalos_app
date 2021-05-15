package com.example.dulcespetalosapp.di

import com.example.dulcespetalosapp.data.api.APIClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiClient(): APIClient {
        return APIClient()
    }

}