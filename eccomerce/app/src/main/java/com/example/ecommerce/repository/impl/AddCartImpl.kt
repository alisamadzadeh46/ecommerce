package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.AddCart
import com.example.ecommerce.repository.AddCartRepository
import com.example.ecommerce.repository.datasource.AddCartDataSource
import io.reactivex.rxjava3.core.Single

class AddCartImpl(
    private val addCartDataSource: AddCartDataSource
) : AddCartRepository {
    override fun addCart(
        access_token: String,
        id: Int,
        count: Int,
        price: Int
    ): Single<List<AddCart>> =
        addCartDataSource.addCart(access_token, id, count, price)


}