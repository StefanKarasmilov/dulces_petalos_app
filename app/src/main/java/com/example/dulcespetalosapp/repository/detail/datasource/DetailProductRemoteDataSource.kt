package com.example.dulcespetalosapp.repository.detail.datasource

import com.example.dulcespetalosapp.models.ProductModel
import retrofit2.Call
import retrofit2.Response

interface DetailProductRemoteDataSource {
    suspend fun getProductByIdFromRemote(productId: String): ProductModel
}