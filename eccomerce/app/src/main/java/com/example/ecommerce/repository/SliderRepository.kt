package com.example.ecommerce.repository

import com.example.ecommerce.model.Slider
import io.reactivex.rxjava3.core.Single

interface SliderRepository {
    fun sliders(): Single<List<Slider>>
}