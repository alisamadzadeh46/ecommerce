package com.example.ecommerce.utils

import android.app.Application
import com.example.ecommerce.network.client
import com.example.ecommerce.repository.SliderRepository
import com.example.ecommerce.repository.datasource.LocalSliderDataSource
import com.example.ecommerce.repository.datasource.RemoteSliderDataSource
import com.example.ecommerce.repository.impl.ImageLoadingImpl
import com.example.ecommerce.repository.impl.SliderRepositoryImpl
import com.example.ecommerce.ui.fragment.home.ImageLoading
import com.example.ecommerce.viewmodel.HomeViewModel
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        val appModules = module {
            single<ImageLoading> { ImageLoadingImpl() }
            single {
                client()
            }
            factory<SliderRepository> {
                SliderRepositoryImpl(
                    RemoteSliderDataSource(get()),
                    LocalSliderDataSource()
                )
            }
            viewModel {
                HomeViewModel(get())
            }

        }
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }
}