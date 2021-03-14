package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Slider
import com.example.ecommerce.network.ApiService
import io.reactivex.rxjava3.core.Single

class RemoteSliderDataSource(
    private val apiService: ApiService
) : SliderDataSource {
    override fun sliders(): Single<List<Slider>> = apiService.home()
}