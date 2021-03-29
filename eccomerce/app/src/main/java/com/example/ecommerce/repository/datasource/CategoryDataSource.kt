package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Category
import com.example.ecommerce.model.Slider
import io.reactivex.rxjava3.core.Single

interface CategoryDataSource {
    fun category(): Single<List<Category>>
}