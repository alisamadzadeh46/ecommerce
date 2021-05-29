package com.example.ecommerce.model

data class AddFavorite(
    val id: Int,
    val is_favorite: Boolean,
    val product: Int,
    val user: Int,
    val available: String,
)