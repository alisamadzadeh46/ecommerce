package com.example.ecommerce.model

data class AddCart(
    val count: Int,
    val id: Int,
    val is_add: Boolean,
    val pay: Boolean,
    val price: String,
    val product: Product,
    val update: Boolean,
)