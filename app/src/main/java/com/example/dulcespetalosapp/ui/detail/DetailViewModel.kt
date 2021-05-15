package com.example.dulcespetalosapp.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dulcespetalosapp.data.api.Resource
import com.example.dulcespetalosapp.repository.detail.DetailProductRepository
import kotlinx.coroutines.Dispatchers

class DetailViewModel @ViewModelInject constructor(
    private val repository: DetailProductRepository
) : ViewModel() {

    fun getDetailProduct(productId: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getProductById(productId)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}