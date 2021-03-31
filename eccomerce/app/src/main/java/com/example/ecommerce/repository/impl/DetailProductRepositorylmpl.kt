package com.example.ecommerce.repository.impl

import com.example.ecommerce.model.ProductDetail
import com.example.ecommerce.repository.DetailProductRepository
import com.example.ecommerce.repository.datasource.DetailProductDataSource
import io.reactivex.rxjava3.core.Single

class DetailProductRepositorylmpl(private val detailProductDataSource: DetailProductDataSource) :
    DetailProductRepository {
    override fun detailProduct(id:Int): Single<ProductDetail> =
        detailProductDataSource.detailProduct(id)



}