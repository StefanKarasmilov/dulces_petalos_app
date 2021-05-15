package com.example.dulcespetalosapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductModel(
    @SerializedName("binomialName")
    val binomialName: String,
    @SerializedName("fertilizerType")
    val fertilizerType: String,
    @SerializedName("heightInCm")
    val heightInCm: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("imgUrl")
    val imgUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("wateringsPerWeek")
    val wateringsPerWeek: Int
) : Serializable