package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Login
import com.example.ecommerce.repository.LoginRepository
import com.example.ecommerce.repository.datasource.LoginDataSource
import io.reactivex.rxjava3.core.Single

class LoginRepositorylmpl(
    private val loginDataSource: LoginDataSource,
    private val localLoginDataSource: LoginDataSource
) : LoginRepository {
    override fun login(username: String, password: String): Single<Login> =
        loginDataSource.login(username, password)


}