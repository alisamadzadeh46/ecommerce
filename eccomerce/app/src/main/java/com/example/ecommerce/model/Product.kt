package com.example.ecommerce.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val amazing: Boolean,
    val amount: Int,
    val category: Int,
    val create_at: String,
    val description: String,
    val detail: String,
    val id: Int,
    val image: String,
    val keywords: String,
    val offer: Int,
    val price: Int,
    val slug: String,
    val status: String,
    val title: String,
    val update_at: String,
    val color: String,
    val warranty: String,
    val score: Float,
    val club:String
): Parcelable