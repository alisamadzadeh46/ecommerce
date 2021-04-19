package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.AddFavorite
import com.example.ecommerce.repository.AddFavoriteRepository
import com.example.ecommerce.repository.datasource.AddFavoriteDataSource
import com.example.ecommerce.repository.datasource.LocalLoginDataSource
import io.reactivex.rxjava3.core.Single

class AddFavoriteImpl(
    private val addFavoriteDataSource: AddFavoriteDataSource
) :
    AddFavoriteRepository {
    override fun addFavorite(id: Int, access_token: String): Single<AddFavorite> =
        addFavoriteDataSource.addFavorite(id, access_token)




}