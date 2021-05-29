package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Login
import io.reactivex.rxjava3.core.Single

interface LoginDataSource {
    fun login(username: String, password: String): Single<Login>
    fun accessToken(access_token: String, refresh_token:String)
    fun loadToken(token:String)
    fun checkLogin():Boolean
}