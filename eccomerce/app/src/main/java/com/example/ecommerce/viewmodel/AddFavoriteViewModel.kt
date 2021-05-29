package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.AddFavorite
import com.example.ecommerce.repository.AddFavoriteRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class AddFavoriteViewModel(
    private val addFavoriteRepository: AddFavoriteRepository,
) : BaseViewModel() {
    val addFavoriteLiveData = MutableLiveData<AddFavorite>()

    fun addFavorite(id: Int, access_token: String) {
        progressbarLiveData.value = true
        addFavoriteRepository.addFavorite(id, access_token)
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<AddFavorite>(compositeDisposable) {
                override fun onSuccess(t: AddFavorite?) {
                    addFavoriteLiveData.value = t!!
                }
            })


    }
}