package com.example.dulcespetalosapp.repository.detail

import com.example.dulcespetalosapp.models.ProductModel

interface DetailProductRepository {
    suspend fun getProductById(productId: String): ProductModel
}