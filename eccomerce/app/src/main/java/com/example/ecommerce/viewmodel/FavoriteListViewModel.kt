package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.FavoriteList
import com.example.ecommerce.repository.FavoriteListRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class FavoriteListViewModel(
    private val favoriteListRepository: FavoriteListRepository
) : BaseViewModel() {
    val favoriteListLiveData = MutableLiveData<List<FavoriteList>>()

    fun listFavorite(access_token: String) {
        progressbarLiveData.value = true
        favoriteListRepository.listFavorite(access_token)
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<List<FavoriteList>>(compositeDisposable) {
                override fun onSuccess(t: List<FavoriteList>?) {
                    favoriteListLiveData.value = t!!
                }

            })


    }
}