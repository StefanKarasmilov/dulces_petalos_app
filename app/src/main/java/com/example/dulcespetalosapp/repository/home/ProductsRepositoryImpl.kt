package com.example.dulcespetalosapp.repository.home

import com.example.dulcespetalosapp.models.ProductModel
import com.example.dulcespetalosapp.repository.home.datasource.ProductsRemoteDataSource
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductsRemoteDataSource
) : ProductsRepository {

    override suspend fun getAllFromRemote(): List<ProductModel> {
        return remoteDataSource.getAllProducts()
    }

}