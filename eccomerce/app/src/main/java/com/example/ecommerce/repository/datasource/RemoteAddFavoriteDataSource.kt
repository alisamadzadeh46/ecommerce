package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.AddFavorite
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteAddFavoriteDataSource(private val apiService: ApiService) : AddFavoriteDataSource {
    override fun addFavorite(id: Int, access_token: String): Single<AddFavorite> =
        apiService.addFavorite(id, access_token)


}