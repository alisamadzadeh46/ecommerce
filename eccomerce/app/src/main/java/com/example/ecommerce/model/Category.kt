package com.example.ecommerce.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Category (
    val create_at: String,
    val id: Int,
    val image: String,
    val level: Int,
    val lft: Int,
    val parent: @RawValue Any? = null,
    val rght: Int,
    val slug: String,
    val status: String,
    val title: String,
    val tree_id: Int,
    val update_at: String
): Parcelable