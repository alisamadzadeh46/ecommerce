package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Category
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteCategoryDetailDataSource(private val apiService: ApiService) :
    CategoryDetailDataSource {
    override fun categoryDetail(id: Int): Single<List<Category>> = apiService.categoryDetail(id)


}