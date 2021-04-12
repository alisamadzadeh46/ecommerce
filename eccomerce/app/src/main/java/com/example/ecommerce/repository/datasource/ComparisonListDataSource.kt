package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.ProductDetail
import io.reactivex.rxjava3.core.Single

interface ComparisonListDataSource {
    fun comparisonProduct(id:Int): Single<ProductDetail>
}