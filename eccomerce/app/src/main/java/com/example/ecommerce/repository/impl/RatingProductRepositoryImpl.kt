package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Rating
import com.example.ecommerce.repository.RatingProductRepository
import com.example.ecommerce.repository.datasource.RatingProductDataSource
import io.reactivex.rxjava3.core.Single

class RatingProductRepositoryImpl(private val ratingProductDataSource: RatingProductDataSource) :
    RatingProductRepository {
    override fun ratingProduct(id: Int): Single<List<Rating>> =
        ratingProductDataSource.ratingProduct(id)


}