package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Login
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteLoginDataSource(private val apiService: ApiService) : LoginDataSource {
    override fun login(username: String, password1: String, password2: String): Single<Login> =
        apiService.login(username, password1, password2)


}