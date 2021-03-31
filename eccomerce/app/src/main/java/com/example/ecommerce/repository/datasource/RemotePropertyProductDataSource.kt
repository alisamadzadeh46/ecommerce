package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Property
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemotePropertyProductDataSource(private val apiService: ApiService) :
    PropertyProductDataSource {
    override fun propertyProduct(id: Int): Single<List<Property>> = apiService.propertyProduct(id)


}