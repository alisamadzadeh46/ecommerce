package com.example.ecommerce.repository

import com.example.ecommerce.model.ProductDetail
import io.reactivex.rxjava3.core.Single

interface DetailProductRepository {
    fun detailProduct(id:Int): Single<ProductDetail>
}