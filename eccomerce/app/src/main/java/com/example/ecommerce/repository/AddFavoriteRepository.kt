package com.example.ecommerce.repository

import com.example.ecommerce.model.AddFavorite
import io.reactivex.rxjava3.core.Single

interface AddFavoriteRepository {
    fun addFavorite(id: Int, access_token: String): Single<AddFavorite>
}