package com.example.ecommerce.model

data class Login(
    val access_token: String,
    val refresh_token: String,
    val user: User
)