package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.AddCart
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteAddCartDataSource(private val apiService: ApiService) : AddCartDataSource {
    override fun addCart(
        access_token: String,
        id: Int,
        count: Int,
        price: Int
    ): Single<List<AddCart>> =
        apiService.addCart(access_token, id, count, price)


}