package com.example.ecommerce.model

data class FavoriteList(
    val id: Int,
    val is_favorite: Boolean,
    val product: Product,
    val user: Int
)