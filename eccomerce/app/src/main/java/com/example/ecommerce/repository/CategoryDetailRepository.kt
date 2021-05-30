package com.example.ecommerce.repository

import com.example.ecommerce.model.Category
import io.reactivex.rxjava3.core.Single

interface CategoryDetailRepository {
    fun categoryDetail(id: Int): Single<List<Category>>
}