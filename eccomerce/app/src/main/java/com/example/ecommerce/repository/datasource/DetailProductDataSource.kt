package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.ProductDetail
import io.reactivex.rxjava3.core.Single

interface DetailProductDataSource {
    fun detailProduct(id:Int): Single<ProductDetail>

}