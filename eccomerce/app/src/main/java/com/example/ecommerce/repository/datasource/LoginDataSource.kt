package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Login
import io.reactivex.rxjava3.core.Single

interface LoginDataSource {
    fun login(username: String, password1: String, password2: String): Single<Login>
}