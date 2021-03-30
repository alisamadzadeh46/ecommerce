package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.model.Slider
import com.example.ecommerce.repository.DetailProductRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class DetailProductViewModel(
    private val detailProductRepository: DetailProductRepository,
    val id: Int
) :
    BaseViewModel() {
    val detailProductLiveData = MutableLiveData<List<ProductDetail>?>()
    val detailProductIdLiveData = MutableLiveData<Int>()

    init {
        progressbarLiveData.value = true
        detailProductRepository.detailProduct(id)
            .singleHelper()
            .subscribe(object : Observer<List<ProductDetail>>(compositeDisposable) {
                override fun onSuccess(t: List<ProductDetail>?) {

                }
            })
    }
}