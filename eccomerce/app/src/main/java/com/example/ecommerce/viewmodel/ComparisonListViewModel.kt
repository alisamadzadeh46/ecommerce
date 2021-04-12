package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.Product
import com.example.ecommerce.repository.ComparisonListRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class ComparisonListViewModel(
    comparisonListRepository: ComparisonListRepository,
    val id: Int
) : BaseViewModel() {
    val comparisonListProductLiveData = MutableLiveData<List<Product>>()
    private val comparisonListProductIdLiveData = MutableLiveData<Int>()
    init {
        progressbarLiveData.value = true
        comparisonListProductIdLiveData.value = id
        comparisonListRepository.comparisonProduct(comparisonListProductIdLiveData.value!!)
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<List<Product>>(compositeDisposable) {
                override fun onSuccess(t: List<Product>) {
                    comparisonListProductLiveData.value = t
                }
            })
    }
}