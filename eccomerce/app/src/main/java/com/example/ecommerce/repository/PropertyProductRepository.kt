package com.example.ecommerce.repository

import com.example.ecommerce.model.Property
import io.reactivex.rxjava3.core.Single

interface PropertyProductRepository {
    fun propertyProduct(id: Int): Single<List<Property>>
}