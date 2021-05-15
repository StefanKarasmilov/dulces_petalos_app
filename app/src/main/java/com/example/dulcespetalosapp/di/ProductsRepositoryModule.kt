package com.example.dulcespetalosapp.di

import com.example.dulcespetalosapp.data.api.APIClient
import com.example.dulcespetalosapp.data.api.APIService
import com.example.dulcespetalosapp.repository.home.ProductsRepository
import com.example.dulcespetalosapp.repository.home.ProductsRepositoryImpl
import com.example.dulcespetalosapp.repository.home.datasource.ProductsRemoteDataSource
import com.example.dulcespetalosapp.repository.home.datasource.ProductsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object ProductsRepositoryModule {

    @Singleton
    @Provides
    fun provideRemoteDataSourceInterface(apiClient: APIClient): ProductsRemoteDataSource {
        return ProductsRemoteDataSourceImpl(apiClient)
    }

    @Singleton
    @Provides
    fun provideProductsRepository(remoteDataSource: ProductsRemoteDataSource): ProductsRepository {
        return ProductsRepositoryImpl(remoteDataSource)
    }

}