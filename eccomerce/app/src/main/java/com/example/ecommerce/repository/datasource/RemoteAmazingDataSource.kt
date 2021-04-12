package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Product
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteAmazingDataSource(private val apiService: ApiService) : AmazingDataSource {
    override fun amazing():Single<List<Product>> = apiService.product()

}