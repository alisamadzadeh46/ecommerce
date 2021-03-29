package com.example.ecommerce.repository.impl

import com.example.ecommerce.custom.ImageView
import com.example.ecommerce.ui.fragment.home.ImageLoading
import com.facebook.drawee.view.SimpleDraweeView

class ImageLoadingImpl : ImageLoading {
    override fun load(imageView: ImageView, imageUrl: String) {
        imageView.setImageURI(imageUrl)
    }
}