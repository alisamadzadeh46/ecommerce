package com.example.ecommerce.repository

import com.example.ecommerce.model.AddCart
import io.reactivex.rxjava3.core.Single

interface AddCartRepository {
    fun addCart(
        access_token: String,
        id: Int,
        count: Int,
        price: Int
    ): Single<List<AddCart>>
}