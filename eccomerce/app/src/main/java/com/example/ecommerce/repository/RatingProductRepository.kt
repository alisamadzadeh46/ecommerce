package com.example.ecommerce.repository

import com.example.ecommerce.model.Rating
import io.reactivex.rxjava3.core.Single

interface RatingProductRepository {
    fun ratingProduct(id:Int):Single<List<Rating>>
}