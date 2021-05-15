package com.example.dulcespetalosapp.di

import com.example.dulcespetalosapp.data.api.APIClient
import com.example.dulcespetalosapp.repository.detail.DetailProductRepository
import com.example.dulcespetalosapp.repository.detail.DetailProductRepositoryImpl
import com.example.dulcespetalosapp.repository.detail.datasource.DetailProductRemoteDataSource
import com.example.dulcespetalosapp.repository.detail.datasource.DetailProductRemoteDataSourceImpl
import com.example.dulcespetalosapp.repository.home.datasource.ProductsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DetailProductRepositoryModule {

    @Singleton
    @Provides
    fun provideRemoteDataSourceInterface(apiClient: APIClient): DetailProductRemoteDataSource {
        return DetailProductRemoteDataSourceImpl(apiClient)
    }

    @Singleton
    @Provides
    fun provideProductsRepository(remoteDataSource: DetailProductRemoteDataSource): DetailProductRepository {
        return DetailProductRepositoryImpl(remoteDataSource)
    }

}