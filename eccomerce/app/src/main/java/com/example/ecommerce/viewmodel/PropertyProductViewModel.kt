package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.model.Property
import com.example.ecommerce.repository.PropertyProductRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class PropertyProductViewModel(
    propertyProductRepository: PropertyProductRepository,
    val id: Int
) :
    BaseViewModel() {
    val propertyProductLiveData = MutableLiveData<List<Property>>()
    private val propertyProductIdLiveData = MutableLiveData<Int>()

    init {
        progressbarLiveData.value = true
        propertyProductIdLiveData.value = id
        propertyProductRepository.propertyProduct(propertyProductIdLiveData.value!!)
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<List<Property>>(compositeDisposable) {
                override fun onSuccess(t: List<Property>) {
                    propertyProductLiveData.value = t
                }
            })

    }
}