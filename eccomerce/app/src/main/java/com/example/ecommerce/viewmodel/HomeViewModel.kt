package com.example.ecommerce.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ecommerce.model.Slider
import com.example.ecommerce.repository.SliderRepository
import com.example.ecommerce.utils.BaseViewModel
import com.example.ecommerce.utils.Observer
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(sliderRepository: SliderRepository) : BaseViewModel() {
    val sliderLiveData = MutableLiveData<List<Slider>>()

    init {
        sliderRepository.sliders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Slider>>(compositeDisposable) {
                override fun onSuccess(t: List<Slider>?) {
                    sliderLiveData.value = t
                }
            })
    }
}