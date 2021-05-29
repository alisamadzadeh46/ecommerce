package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Login
import com.example.ecommerce.repository.LoginRepository
import com.example.ecommerce.repository.datasource.LoginDataSource
import com.example.ecommerce.utils.TokenHolder
import io.reactivex.rxjava3.core.Single

class LoginRepositorylmpl(
    private val loginDataSource: LoginDataSource,
    private val localLoginDataSource: LoginDataSource
) : LoginRepository {
    override fun login(username: String, password: String): Single<Login> {
        return loginDataSource.login(username, password).doOnSuccess {
            TokenHolder.updateToken(it.access_token, it.access_token)
            localLoginDataSource.accessToken(it.access_token, it.refresh_token)
        }
    }

    override fun checkLogin(): Boolean {
        return localLoginDataSource.checkLogin()
    }



}