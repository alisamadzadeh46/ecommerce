package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Rating
import io.reactivex.rxjava3.core.Single

interface RatingProductDataSource {
    fun ratingProduct(id:Int): Single<List<Rating>>
}