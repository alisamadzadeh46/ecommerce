package com.example.ecommerce.viewmodel


import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.Slider
import com.example.ecommerce.repository.SliderRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(sliderRepository: SliderRepository) : BaseViewModel() {
    val sliderLiveData = MutableLiveData<List<Slider>?>()


    init {
        progressbarLiveData.value = true
        sliderRepository.sliders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                progressbarLiveData.value = false
            }
            .subscribe(object : Observer<List<Slider>>(compositeDisposable) {
                override fun onSuccess(t: List<Slider>?) {
                    sliderLiveData.value = t
                }
            })
    }
}