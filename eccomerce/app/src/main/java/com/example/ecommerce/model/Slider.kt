package com.example.ecommerce.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Slider(
    val id: Int,
    val image: String,
    val name: String
):Parcelable