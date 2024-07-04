package com.determent.ecombebop_management.shared.home_content.add_product.domain.model

data class ProductItemRelationItemModel(
    val mainImage: Byte = 0,
    val price: Int = 0,
    val discount: Int = 0,
    val priceCalculated: Int = 0,
    val title: String = "",
    val brand: String = ""
)