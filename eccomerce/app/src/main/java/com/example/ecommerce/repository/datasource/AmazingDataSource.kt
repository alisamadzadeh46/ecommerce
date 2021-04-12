package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Product
import io.reactivex.rxjava3.core.Single

interface AmazingDataSource {
    fun amazing(): Single<List<Product>>
}