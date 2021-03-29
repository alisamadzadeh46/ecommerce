package com.example.ecommerce.network

import com.example.ecommerce.model.Amazing
import com.example.ecommerce.model.Category
import com.example.ecommerce.model.Slider
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("home")
    fun home(): Single<List<Slider>>

    @GET("home/category")
    fun category(): Single<List<Category>>

    @GET("home/amazing")
    fun amazing(): Single<List<Amazing>>
}


fun client(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.33:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)

}