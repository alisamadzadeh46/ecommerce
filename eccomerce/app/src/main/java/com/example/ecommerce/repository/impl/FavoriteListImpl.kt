package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.FavoriteList
import com.example.ecommerce.repository.FavoriteListRepository
import com.example.ecommerce.repository.datasource.FavoriteListDataSource
import io.reactivex.rxjava3.core.Single

class FavoriteListImpl(private val favoriteListDataSource: FavoriteListDataSource) :
    FavoriteListRepository {
    override fun listFavorite(access_token: String): Single<List<FavoriteList>> =
        favoriteListDataSource.listFavorite(access_token)


}