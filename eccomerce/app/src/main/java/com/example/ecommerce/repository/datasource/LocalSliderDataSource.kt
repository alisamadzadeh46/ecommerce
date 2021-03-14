package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Slider
import io.reactivex.rxjava3.core.Single

class LocalSliderDataSource:SliderDataSource{
    override fun sliders(): Single<List<Slider>> {
        TODO("Not yet implemented")
    }
}