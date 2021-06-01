package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.AddCart
import io.reactivex.rxjava3.core.Single

interface AddCartDataSource {
    fun addCart(
        access_token: String,
        id: Int,
        count: Int,
        price: Int
    ): Single<List<AddCart>>
}