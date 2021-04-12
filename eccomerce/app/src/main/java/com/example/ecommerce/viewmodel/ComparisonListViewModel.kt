package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.repository.ComparisonListRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class ComparisonListViewModel(
    comparisonListRepository: ComparisonListRepository,
    val id: Int
) : BaseViewModel() {
    val comparisonListProductLiveData = MutableLiveData<ProductDetail>()
    private val comparisonListProductIdLiveData = MutableLiveData<Int>()
    init {
        progressbarLiveData.value = true
        comparisonListProductIdLiveData.value = id
        comparisonListRepository.comparisonProduct(comparisonListProductIdLiveData.value!!)
            .singleHelper()
            .subscribe(object : Observer<ProductDetail>(compositeDisposable) {
                override fun onSuccess(t: ProductDetail) {
                    comparisonListProductLiveData.value = t
                }
            })
    }
}