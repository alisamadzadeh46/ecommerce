package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Property
import io.reactivex.rxjava3.core.Single

interface PropertyProductDataSource {
    fun propertyProduct(id: Int): Single<List<Property>>
}