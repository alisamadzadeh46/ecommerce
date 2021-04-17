package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Login
import io.reactivex.rxjava3.core.Single

interface RegisterDataSource {
    fun register(username: String, password1: String, password2: String): Single<Login>
    fun accessToken(access_token: String, refresh_token: String)
    fun loadToken(token: String)
}