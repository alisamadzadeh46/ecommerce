package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Login
import com.example.ecommerce.repository.LoginRepository
import com.example.ecommerce.repository.datasource.LoginDataSource
import io.reactivex.rxjava3.core.Single

class LoginRepositorylmpl(private val loginDataSource: LoginDataSource) : LoginRepository {
    override fun login(username: String, password1: String, password2: String): Single<Login> =
        loginDataSource.login(username, password1, password2)

}