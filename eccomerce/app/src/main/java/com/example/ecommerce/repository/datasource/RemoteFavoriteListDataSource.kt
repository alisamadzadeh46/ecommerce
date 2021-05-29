package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.AddFavorite
import com.example.ecommerce.model.FavoriteList
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteFavoriteListDataSource(val apiService: ApiService) : FavoriteListDataSource {
    override fun listFavorite(access_token: String): Single<List<FavoriteList>> =
        apiService.listFavorite(access_token)


}