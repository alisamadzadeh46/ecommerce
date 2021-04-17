package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.Login
import com.example.ecommerce.repository.LoginRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class LoginViewModel(
    private val loginRepository: LoginRepository,
) : BaseViewModel() {
    val loginLiveData = MutableLiveData<Login>()
    fun login(
        username: String,
        password: String
    ) {
        progressbarLiveData.postValue(true)
        loginRepository.login(username, password)
            .doFinally {
//                progressbarLiveData.value = false
                progressbarLiveData.postValue(false)
            }
            .singleHelper()
            .subscribe(object : Observer<Login>(compositeDisposable) {
                override fun onSuccess(t: Login) {
                    loginLiveData.value = t
                }

            })
    }


}