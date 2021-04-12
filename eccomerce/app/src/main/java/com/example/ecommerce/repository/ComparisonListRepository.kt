package com.example.ecommerce.repository

import com.example.ecommerce.model.ProductDetail
import io.reactivex.rxjava3.core.Single

interface ComparisonListRepository {
    fun comparisonProduct(id:Int):Single<ProductDetail>
}