package com.determent.ecombebop_management.shared.home_content.list_product.a_domain.model

data class ProductItem(
    val mainImage: Byte,
    val price: Int,
    val discount: Double,
    val priceCalculated: Int,
    val title: String,
    val brand: String
)
