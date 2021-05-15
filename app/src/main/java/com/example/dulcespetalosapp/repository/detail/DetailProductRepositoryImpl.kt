package com.example.dulcespetalosapp.repository.detail

import com.example.dulcespetalosapp.models.ProductModel
import com.example.dulcespetalosapp.repository.detail.datasource.DetailProductRemoteDataSource
import javax.inject.Inject

class DetailProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: DetailProductRemoteDataSource
) : DetailProductRepository {

    override suspend fun getProductById(productId: String): ProductModel =
        remoteDataSource.getProductByIdFromRemote(productId)

}