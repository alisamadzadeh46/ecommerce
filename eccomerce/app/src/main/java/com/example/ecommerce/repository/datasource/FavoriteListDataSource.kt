package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.FavoriteList
import io.reactivex.rxjava3.core.Single

interface FavoriteListDataSource {
    fun listFavorite(access_token:String): Single<List<FavoriteList>>
}