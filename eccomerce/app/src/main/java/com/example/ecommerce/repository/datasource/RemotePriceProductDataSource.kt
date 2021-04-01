package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Price
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemotePriceProductDataSource(private val apiService: ApiService) : PriceProductDataSource {
    override fun priceProduct(id: Int): Single<List<Price>> = apiService.priceProduct(id)

}