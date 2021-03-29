package com.example.ecommerce.utils

import android.app.Application
import com.example.ecommerce.model.Category
import com.example.ecommerce.network.client
import com.example.ecommerce.repository.CategoryRepository
import com.example.ecommerce.repository.SliderRepository
import com.example.ecommerce.repository.datasource.LocalSliderDataSource
import com.example.ecommerce.repository.datasource.RemoteCategoryDataSource
import com.example.ecommerce.repository.datasource.RemoteSliderDataSource
import com.example.ecommerce.repository.impl.CategoryRepositoryImpl
import com.example.ecommerce.repository.impl.ImageLoadingImpl
import com.example.ecommerce.repository.impl.SliderRepositoryImpl
import com.example.ecommerce.ui.adapter.CategoryAdapter
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
            factory<CategoryRepository> {
                CategoryRepositoryImpl(
                    RemoteCategoryDataSource(get())
                )
            }
            factory { (category: List<Category>) -> CategoryAdapter(category,get()) }
            viewModel {
                HomeViewModel(get(), get())
            }


        }
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }
}