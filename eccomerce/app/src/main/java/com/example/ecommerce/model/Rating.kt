package com.example.ecommerce.model

data class Rating(
    val id: Int,
    val product: Int,
    val title: String,
    val value: Float
)