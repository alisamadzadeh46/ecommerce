package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Property
import com.example.ecommerce.repository.PropertyProductRepository
import com.example.ecommerce.repository.datasource.PropertyProductDataSource
import io.reactivex.rxjava3.core.Single

class PropertyProductImpl(private val propertyProductDataSource: PropertyProductDataSource) :
    PropertyProductRepository {
    override fun propertyProduct(id: Int): Single<List<Property>> =
        propertyProductDataSource.propertyProduct(id)


}