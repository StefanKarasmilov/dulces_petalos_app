package com.example.dulcespetalosapp.repository.home.datasource

import com.example.dulcespetalosapp.data.api.APIClient
import com.example.dulcespetalosapp.models.ProductModel
import javax.inject.Inject

class ProductsRemoteDataSourceImpl @Inject constructor(
    private val apiClient: APIClient
) : ProductsRemoteDataSource {

    override suspend fun getAllProducts(): List<ProductModel> =
        apiClient.apiService.getAllProducts()

}