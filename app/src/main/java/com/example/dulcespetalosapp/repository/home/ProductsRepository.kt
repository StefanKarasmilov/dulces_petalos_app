package com.example.dulcespetalosapp.repository.home

import com.example.dulcespetalosapp.models.ProductModel

interface ProductsRepository {
    suspend fun getAllFromRemote(): List<ProductModel>
}