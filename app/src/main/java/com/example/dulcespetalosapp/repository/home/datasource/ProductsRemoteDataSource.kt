package com.example.dulcespetalosapp.repository.home.datasource

import com.example.dulcespetalosapp.models.ProductModel
import retrofit2.Call
import retrofit2.Response

interface ProductsRemoteDataSource {
    suspend fun getAllProducts(): List<ProductModel>
}