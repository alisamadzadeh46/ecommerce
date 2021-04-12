package com.example.ecommerce.di

import android.app.Application
import com.example.ecommerce.model.Category
import com.example.ecommerce.model.Product
import com.example.ecommerce.model.Property
import com.example.ecommerce.model.Rating
import com.example.ecommerce.network.client
import com.example.ecommerce.repository.*
import com.example.ecommerce.repository.datasource.*
import com.example.ecommerce.repository.impl.*
import com.example.ecommerce.ui.adapter.*
import com.example.ecommerce.ui.fragment.home.ImageLoading
import com.example.ecommerce.viewmodel.*
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
            factory { (product: List<Product>) -> AmazingAdapter(product, get()) }
            factory { (property: List<Property>) -> PropertyProductAdapter(property) }
            factory { (rating: List<Rating>) -> AdapterRatingProduct(rating) }
            factory<AmazingRepository> { AmazingRepositoryImpl(RemoteAmazingDataSource(get())) }
            factory<DetailProductRepository> {
                DetailProductRepositorylmpl(
                    RemoteDetailDataSource(
                        get()
                    )
                )
            }
            factory<PropertyProductRepository> {
                PropertyProductImpl(
                    RemotePropertyProductDataSource(
                        get()
                    )
                )
            }
            factory<RatingProductRepository> {
                RatingProductRepositoryImpl(
                    RemoteRatingProductDataSource(get())
                )
            }
            factory<PriceProductRepository> {
                PriceProductRepositorylmpl(
                    RemotePriceProductDataSource(get())
                )
            }
            factory<ComparisonListRepository> {
                ComparisonListImpl(
                    RemoteComparisonListDataSource(get())
                )
            }
            factory { ComparisonProductListAdapter(get()) }
            viewModel {
                HomeViewModel(get(), get(), get())
            }
            viewModel { (id: Int) ->
                DetailProductViewModel(get(), get(), id)
            }
            viewModel { (id: Int) ->
                PropertyProductViewModel(get(), id)
            }
            viewModel { (id: Int) ->
                PriceProductViewModel(get(), id)
            }

            viewModel { (id: Int) ->
                ComparisonListViewModel(get(), id)
            }


        }
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }
}