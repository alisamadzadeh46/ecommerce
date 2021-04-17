package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Login
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteRegisterDataSource(private val apiService: ApiService) : RegisterDataSource {
    override fun register(username: String, password1: String, password2: String): Single<Login> =
        apiService.register(username, password1, password2)


    override fun accessToken(access_token: String, refresh_token: String) {
        TODO("Not yet implemented")
    }

    override fun loadToken(token: String) {
        TODO("Not yet implemented")
    }


}