package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.model.Rating
import com.example.ecommerce.repository.DetailProductRepository
import com.example.ecommerce.repository.RatingProductRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class DetailProductViewModel(
    detailProductRepository: DetailProductRepository,
    ratingProductRepository: RatingProductRepository,
    val id: Int

) :
    BaseViewModel() {
    val detailProductLiveData = MutableLiveData<ProductDetail>()
    val ratingProductLiveData = MutableLiveData<List<Rating>>()
    private val detailProductIdLiveData = MutableLiveData<Int>()

    init {
        progressbarLiveData.value = true
        detailProductIdLiveData.value = id
        detailProductRepository.detailProduct(detailProductIdLiveData.value!!)
            .singleHelper()
            .subscribe(object : Observer<ProductDetail>(compositeDisposable) {
                override fun onSuccess(t: ProductDetail) {
                    detailProductLiveData.value = t
                }
            })
        ratingProductRepository.ratingProduct(detailProductIdLiveData.value!!)
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<List<Rating>>(compositeDisposable) {
                override fun onSuccess(t: List<Rating>) {
                    ratingProductLiveData.value = t
                }
            })

    }
}