package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Rating
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteRatingProductDataSource(private val apiService: ApiService) : RatingProductDataSource {
    override fun ratingProduct(id: Int): Single<List<Rating>> = apiService.ratingProduct(id)


}