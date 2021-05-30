package com.example.ecommerce.network

import com.example.ecommerce.model.*
import com.example.ecommerce.utils.TokenHolder
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
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
    fun product(): Single<List<Product>>

    @GET("home/product/{id}/")
    fun detailProduct(@Path("id") id: Int): Single<ProductDetail>

    @GET("home/property/{id}/")
    fun propertyProduct(@Path("id") id: Int): Single<List<Property>>

    @GET("home/rating/{id}/")
    fun ratingProduct(@Path("id") id: Int): Single<List<Rating>>

    @GET("home/price/")
    fun priceProduct(@Query("id") id: Int): Single<List<Price>>

    @GET("home/comparison/{id}/")
    fun comparisonProduct(@Path("id") id: Int): Single<List<Product>>


    @FormUrlEncoded
    @POST("account/dj-rest-auth/login/")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Single<Login>


    @FormUrlEncoded
    @POST("account/dj-rest-auth/registration/")
    fun register(
        @Field("username") username: String,
        @Field("password1") password1: String,
        @Field("password2") password2: String
    ): Single<Login>


    @POST("account/addfavorite/{id}/")
    fun addFavorite(
        @Path("id") id: Int,
        @Header("Authorization") access_token: String
    ): Single<AddFavorite>

    @POST("account/listfavorite/")
    fun listFavorite(
        @Header("Authorization") access_token: String
    ): Single<List<FavoriteList>>

    @GET("home/categorydetail/{id}/")
    fun categoryDetail(@Path("id") id: Int): Single<List<Product>>
}


fun client(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.8.157:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)

}