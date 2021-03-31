package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.repository.DetailProductRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class DetailProductViewModel(
    detailProductRepository: DetailProductRepository,
    val id: Int

) :
    BaseViewModel() {
    val detailProductLiveData = MutableLiveData<ProductDetail>()
    private val detailProductIdLiveData = MutableLiveData<Int>()

    init {
        progressbarLiveData.value = true
        detailProductIdLiveData.value = id
        detailProductRepository.detailProduct(detailProductIdLiveData.value!!)
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<ProductDetail>(compositeDisposable) {
                override fun onSuccess(t: ProductDetail) {
                    detailProductLiveData.value = t
                }
            })

    }
}