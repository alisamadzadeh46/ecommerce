package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Login
import com.example.ecommerce.repository.RegisterRepository
import com.example.ecommerce.repository.datasource.RegisterDataSource
import com.example.ecommerce.utils.TokenHolder
import io.reactivex.rxjava3.core.Single

class RegisterRepositorylmpl(
    private val registerDataSource: RegisterDataSource,
    private val localRegisterDataSource: RegisterDataSource
) : RegisterRepository {
    override fun register(username: String, password1: String, password2: String): Single<Login> {
        return registerDataSource.register(username, password1, password2).doOnSuccess {
            TokenHolder.updateToken(it.access_token, it.access_token)
            localRegisterDataSource.accessToken(it.access_token, it.refresh_token)
        }
    }


}