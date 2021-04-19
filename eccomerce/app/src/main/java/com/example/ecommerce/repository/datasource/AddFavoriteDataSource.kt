package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.AddFavorite
import io.reactivex.rxjava3.core.Single

interface AddFavoriteDataSource {
    fun addFavorite(id: Int, access_token: String): Single<AddFavorite>
}