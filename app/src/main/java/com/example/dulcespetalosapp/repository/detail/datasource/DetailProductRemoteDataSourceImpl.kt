package com.example.dulcespetalosapp.repository.detail.datasource

import com.example.dulcespetalosapp.data.api.APIClient
import com.example.dulcespetalosapp.models.ProductModel
import javax.inject.Inject

class DetailProductRemoteDataSourceImpl @Inject constructor(
    private val apiClient: APIClient
) : DetailProductRemoteDataSource {

    override suspend fun getProductByIdFromRemote(productId: String): ProductModel =
        apiClient.apiService.getProductById(productId)

}