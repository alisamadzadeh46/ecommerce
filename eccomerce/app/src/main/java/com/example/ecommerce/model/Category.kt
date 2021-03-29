package com.example.ecommerce.model

data class Category(
    val create_at: String,
    val id: Int,
    val image: String,
    val level: Int,
    val lft: Int,
    val parent: Any,
    val rght: Int,
    val slug: String,
    val status: String,
    val title: String,
    val tree_id: Int,
    val update_at: String
)