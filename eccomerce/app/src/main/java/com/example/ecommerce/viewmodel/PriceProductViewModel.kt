package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.Price
import com.example.ecommerce.repository.PriceProductRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class PriceProductViewModel(
    priceProductRepository: PriceProductRepository,
    val id: Int
) : BaseViewModel() {
    val priceProductLiveData = MutableLiveData<List<Price>>()
    private val priceProductIdLiveData = MutableLiveData<Int>()

    init {
        progressbarLiveData.value = true
        priceProductIdLiveData.value = id
        priceProductRepository.priceProduct(priceProductIdLiveData.value!!)
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<List<Price>>(compositeDisposable) {
                override fun onSuccess(t: List<Price>) {
                    priceProductLiveData.value = t
                }
            })
    }
}