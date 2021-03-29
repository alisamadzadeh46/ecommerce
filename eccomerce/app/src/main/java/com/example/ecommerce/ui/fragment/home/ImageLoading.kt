package com.example.ecommerce.ui.fragment.home

import com.example.ecommerce.custom.ImageView


interface ImageLoading {
    fun load(imageView: ImageView, imageUrl: String)
}