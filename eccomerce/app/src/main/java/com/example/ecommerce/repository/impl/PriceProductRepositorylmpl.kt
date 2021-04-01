package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.Price
import com.example.ecommerce.repository.PriceProductRepository
import com.example.ecommerce.repository.datasource.PriceProductDataSource
import io.reactivex.rxjava3.core.Single

class PriceProductRepositorylmpl(private val priceProductDataSource: PriceProductDataSource):PriceProductRepository {
    override fun priceProduct(id: Int): Single<List<Price>> = priceProductDataSource.priceProduct(id)


}