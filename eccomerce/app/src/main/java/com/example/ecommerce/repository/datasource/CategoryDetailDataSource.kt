package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Category
import io.reactivex.rxjava3.core.Single

interface CategoryDetailDataSource {
    fun categoryDetail(id: Int): Single<List<Category>>
}