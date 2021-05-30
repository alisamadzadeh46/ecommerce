package com.example.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.Category
import com.example.ecommerce.model.Product
import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.model.Rating
import com.example.ecommerce.repository.CategoryDetailRepository
import com.example.ecommerce.repository.DetailProductRepository
import com.example.ecommerce.repository.RatingProductRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper

class CategoryDetailViewModel(
    categoryDetailRepository: CategoryDetailRepository,
    val id: Int

) :
    BaseViewModel() {
    val  categoryDetailLiveData = MutableLiveData<List<Product>>()
    private val detailProductIdLiveData = MutableLiveData<Int>()

    init {
        progressbarLiveData.value = true
        detailProductIdLiveData.value = id
        categoryDetailRepository.categoryDetail(detailProductIdLiveData.value!!)
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<List<Product>>(compositeDisposable) {
                override fun onSuccess(t: List<Product>) {
                    categoryDetailLiveData.value = t
                }
            })

    }
}