package com.example.ecommerce.repository

import com.example.ecommerce.model.FavoriteList
import io.reactivex.rxjava3.core.Single

interface FavoriteListRepository {
    fun listFavorite(access_token:String):Single<List<FavoriteList>>
}