package com.example.dulcespetalosapp.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dulcespetalosapp.data.api.Resource
import com.example.dulcespetalosapp.models.ProductModel
import com.example.dulcespetalosapp.repository.home.ProductsRepository
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel @ViewModelInject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private var allProducts: List<ProductModel> = emptyList()

    private val _products = MutableLiveData<Resource<List<ProductModel>>>()
    val products: LiveData<Resource<List<ProductModel>>>
        get() = _products

    init {
        getFlowers()
    }

    private fun getFlowers() {
        _products.postValue(Resource.loading(data = null))
        try {
            viewModelScope.launch {
                val allFromRemote = productsRepository.getAllFromRemote()
                _products.postValue(Resource.success(data = allFromRemote))
                allProducts = allFromRemote
            }
        } catch (exception: Exception) {
            _products.postValue(
                Resource.error(
                    data = null,
                    message = exception.message ?: "Error Occurred!"
                )
            )
        }
    }

    fun searchByName(name: CharSequence?) {
        if (!name.isNullOrEmpty()) {
            _products.postValue(Resource.success(data = allProducts.filter {
                it.name.toLowerCase(Locale.ROOT).contains(name)
            }))
        } else {
            _products.postValue(Resource.success(data = allProducts))
        }
    }

}