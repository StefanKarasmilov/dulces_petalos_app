package com.example.dulcespetalosapp.data.api

import com.example.dulcespetalosapp.models.ProductModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET(APIEndpoints.ALL_PRODUCTS_ENDPOINT)
    suspend fun getAllProducts(): List<ProductModel>

    @GET(APIEndpoints.DETAIL_PRODUCT_ENDPOINT)
    suspend fun getProductById(@Path("id") productId: String): ProductModel

}