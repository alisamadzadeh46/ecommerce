package com.example.ecommerce.viewmodel


import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.Category
import com.example.ecommerce.model.Product
import com.example.ecommerce.model.Slider
import com.example.ecommerce.repository.AmazingRepository
import com.example.ecommerce.repository.CategoryRepository
import com.example.ecommerce.repository.SliderRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper


class HomeViewModel(
    sliderRepository: SliderRepository,
    categoryRepository: CategoryRepository,
    amazingRepository: AmazingRepository
) :
    BaseViewModel() {
    val sliderLiveData = MutableLiveData<List<Slider>?>()
    val categoryLiveDate = MutableLiveData<List<Category>?>()
    val amazingLiveDate = MutableLiveData<List<Product>?>()

    init {
        progressbarLiveData.value = true
        sliderRepository.sliders()
            .singleHelper()
            .subscribe(object : Observer<List<Slider>>(compositeDisposable) {
                override fun onSuccess(t: List<Slider>?) {
                    sliderLiveData.value = t
                }
            })
        categoryRepository.category()
            .singleHelper()
            .subscribe(object : Observer<List<Category>>(compositeDisposable) {
                override fun onSuccess(t: List<Category>?) {
                    categoryLiveDate.value = t
                }

            })
        amazingRepository.amazing()
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<List<Product>>(compositeDisposable) {
                override fun onSuccess(t: List<Product>?) {
                    amazingLiveDate.value = t
                }

            })

    }
}