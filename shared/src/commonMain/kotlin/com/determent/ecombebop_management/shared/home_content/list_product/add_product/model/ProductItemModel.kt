package com.determent.ecombebop_management.shared.home_content.list_product.add_product.model

data class ProductItemModel(
    val listImage: List<ImagePhoto>,
    val productName: String,
    val price: Int,
    val sale: Int?,
    val brand: String?,
)

