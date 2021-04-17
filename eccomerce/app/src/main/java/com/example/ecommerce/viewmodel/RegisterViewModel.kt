package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.Login
import com.example.ecommerce.repository.LoginRepository
import com.example.ecommerce.repository.RegisterRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class RegisterViewModel(
    private val registerRepository: RegisterRepository,
) : BaseViewModel() {
    val registerLiveData = MutableLiveData<Login>()
    fun login(
        username: String,
        password1: String,
        password2: String,
    ) {
        progressbarLiveData.postValue(true)
        registerRepository.register(username, password1,password2)
            .doFinally {
                progressbarLiveData.postValue(false)
            }
            .singleHelper()
            .subscribe(object : Observer<Login>(compositeDisposable) {
                override fun onSuccess(t: Login) {
                    registerLiveData.value = t
                }

            })
    }


}