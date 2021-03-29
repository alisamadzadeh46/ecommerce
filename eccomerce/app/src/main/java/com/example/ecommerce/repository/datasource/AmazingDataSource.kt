package com.example.ecommerce.repository.datasource

import com.example.ecommerce.model.Amazing
import io.reactivex.rxjava3.core.Single

interface AmazingDataSource {
    fun amazing(): Single<List<Amazing>>
}