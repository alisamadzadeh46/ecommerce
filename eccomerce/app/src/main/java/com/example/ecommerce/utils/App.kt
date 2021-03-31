package com.example.ecommerce.utils

import android.app.Application
import com.example.ecommerce.model.Amazing
import com.example.ecommerce.model.Category
import com.example.ecommerce.network.client
import com.example.ecommerce.repository.AmazingRepository
import com.example.ecommerce.repository.CategoryRepository
import com.example.ecommerce.repository.DetailProductRepository
import com.example.ecommerce.repository.SliderRepository
import com.example.ecommerce.repository.datasource.*
import com.example.ecommerce.repository.impl.*
import com.example.ecommerce.ui.adapter.AmazingAdapter
import com.example.ecommerce.ui.adapter.CategoryAdapter
import com.example.ecommerce.ui.fragment.home.ImageLoading
import com.example.ecommerce.viewmodel.DetailProductViewModel
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
            factory { (category: List<Category>) -> CategoryAdapter(category, get()) }
            factory { (amazing: List<Amazing>) -> AmazingAdapter(amazing, get()) }
            factory<AmazingRepository> { AmazingRepositoryImpl(RemoteAmazingDataSource(get())) }
            factory<DetailProductRepository> { DetailProductRepositorylmpl(RemoteDetailDataSource(get())) }
            viewModel {
                HomeViewModel(get(), get(), get())
            }
            viewModel { (id: Int) ->
                DetailProductViewModel(get(), id)
            }


        }
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }
}