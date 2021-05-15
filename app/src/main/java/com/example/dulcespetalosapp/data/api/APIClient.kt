package com.example.dulcespetalosapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    val apiService: APIService by lazy {
        Retrofit.Builder()
            .baseUrl(APIEndpoints.BASE_PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

}