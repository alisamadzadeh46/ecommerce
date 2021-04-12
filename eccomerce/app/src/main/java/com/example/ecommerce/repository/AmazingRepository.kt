package com.example.ecommerce.repository

import com.example.ecommerce.model.Product
import io.reactivex.rxjava3.core.Single

interface AmazingRepository {
    fun amazing(): Single<List<Product>>
}