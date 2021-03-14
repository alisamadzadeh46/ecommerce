package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Slider
import com.example.ecommerce.repository.SliderRepository
import com.example.ecommerce.repository.datasource.LocalSliderDataSource
import com.example.ecommerce.repository.datasource.RemoteSliderDataSource
import com.example.ecommerce.repository.datasource.SliderDataSource
import io.reactivex.rxjava3.core.Single

class SliderRepositoryImpl(
    private val sliderDataSource: SliderDataSource,
    private val localSliderDataSource: SliderDataSource
) : SliderRepository {

    override fun sliders(): Single<List<Slider>> = sliderDataSource.sliders()

}