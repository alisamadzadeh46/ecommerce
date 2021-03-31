package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteDetailDataSource(private val apiService: ApiService) : DetailProductDataSource {
    override fun detailProduct(id: Int): Single<ProductDetail> = apiService.detailProduct(id)


}