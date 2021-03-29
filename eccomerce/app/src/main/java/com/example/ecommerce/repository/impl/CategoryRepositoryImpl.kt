package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Category
import com.example.ecommerce.repository.CategoryRepository
import com.example.ecommerce.repository.datasource.CategoryDataSource
import io.reactivex.rxjava3.core.Single

class CategoryRepositoryImpl(private val categoryDataSource: CategoryDataSource) :
    CategoryRepository {
    override fun category(): Single<List<Category>> = categoryDataSource.category()

}