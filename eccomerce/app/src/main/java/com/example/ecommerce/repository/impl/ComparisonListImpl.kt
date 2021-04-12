package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Product
import com.example.ecommerce.repository.ComparisonListRepository
import com.example.ecommerce.repository.datasource.ComparisonListDataSource
import io.reactivex.rxjava3.core.Single

class ComparisonListImpl(private val dataSource: ComparisonListDataSource) :
    ComparisonListRepository {
    override fun comparisonProduct(id: Int): Single<List<Product>> =
        dataSource.comparisonProduct(id)
}