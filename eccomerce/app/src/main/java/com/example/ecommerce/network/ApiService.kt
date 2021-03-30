package com.example.ecommerce.network

import com.example.ecommerce.model.Amazing
import com.example.ecommerce.model.Category
import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.model.Slider
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("home")
    fun home(): Single<List<Slider>>

    @GET("home/category")
    fun category(): Single<List<Category>>

    @GET("home/product")
    fun product(): Single<List<Amazing>>

    @GET("home/product/{id}")
    fun detailProduct(@Path("id") id: Int): Single<List<ProductDetail>>
}


fun client(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.33:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)

}