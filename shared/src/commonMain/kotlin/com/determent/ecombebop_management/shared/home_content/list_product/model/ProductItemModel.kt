package com.determent.ecombebop_management.shared.home_content.list_product.model

data class ProductItemModel(
    val mainImage: Byte,
    val price: Int,
    val discount: Int,
    val priceCalculated: Int,
    val title: String,
    val brand: String
)
