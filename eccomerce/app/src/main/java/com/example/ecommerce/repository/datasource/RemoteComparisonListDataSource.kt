package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteComparisonListDataSource(private val apiService: ApiService):ComparisonListDataSource {
    override fun comparisonProduct(id: Int): Single<ProductDetail> = apiService.comparisonProduct(id)


}