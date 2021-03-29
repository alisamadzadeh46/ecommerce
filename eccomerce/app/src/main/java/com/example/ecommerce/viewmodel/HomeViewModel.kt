package com.example.ecommerce.viewmodel


import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.Category
import com.example.ecommerce.model.Slider
import com.example.ecommerce.repository.CategoryRepository
import com.example.ecommerce.repository.SliderRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper


class HomeViewModel(sliderRepository: SliderRepository, categoryRepository: CategoryRepository) :
    BaseViewModel() {
    val sliderLiveData = MutableLiveData<List<Slider>?>()
    val categoryLiveDate = MutableLiveData<List<Category>?>()

    init {
        progressbarLiveData.value = true
        sliderRepository.sliders()
            .singleHelper()
            .doFinally {
                progressbarLiveData.value = false
            }
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

    }
}