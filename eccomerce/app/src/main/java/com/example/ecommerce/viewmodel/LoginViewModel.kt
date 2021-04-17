package com.example.ecommerce.viewmodel

import com.example.ecommerce.model.Login
import com.example.ecommerce.repository.LoginRepository
import com.example.ecommerce.repository.datasource.LocalLoginDataSource
import com.example.ecommerce.repository.datasource.LoginDataSource
import com.example.ecommerce.utils.BaseViewModel
import io.reactivex.rxjava3.core.Single

class LoginViewModel(
    private val loginRepository: LoginRepository
) : BaseViewModel() {

    fun login(
        username: String,
        password1: String,
        password2: String
    ): Single<Login> {
        progressbarLiveData.value = true
        return loginRepository.login(username, password1, password2)
            .doFinally {
                progressbarLiveData.value = false
            }
    }

}