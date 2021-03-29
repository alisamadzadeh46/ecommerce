package com.example.ecommerce.repository

import com.example.ecommerce.model.Category
import io.reactivex.rxjava3.core.Single

interface CategoryRepository {
    fun category(): Single<List<Category>>
}