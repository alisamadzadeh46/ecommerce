package com.example.ecommerce.repository

import com.example.ecommerce.model.Login
import io.reactivex.rxjava3.core.Single

interface LoginRepository {
    fun login(username: String, password: String): Single<Login>
    fun checkLogin():Boolean
}