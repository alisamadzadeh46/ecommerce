package com.example.ecommerce.network

import com.example.ecommerce.model.*
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiService {
    @GET("home")
    fun home(): Single<List<Slider>>

    @GET("home/category")
    fun category(): Single<List<Category>>

    @GET("home/product")
    fun product(): Single<List<Amazing>>

    @GET("home/product/{id}/")
    fun detailProduct(@Path("id") id: Int): Single<ProductDetail>

    @GET("home/property/{id}/")
    fun propertyProduct(@Path("id") id: Int): Single<List<Property>>

    @GET("home/rating/{id}/")
    fun ratingProduct(@Path("id") id: Int): Single<List<Rating>>

    @GET("home/price/")
    fun priceProduct(@Query("id") id: Int): Single<List<Price>>

    @GET("home/comparison/{id}/")
    fun comparisonProduct(@Path("id") id: Int): Single<ProductDetail>

}


fun client(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.36:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)

}