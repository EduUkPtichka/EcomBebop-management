package com.determent.ecombebop_management.shared.home_content.list_product.domain.model

data class CardItemModel(
    val urlImagery: String,
    val productName: String,
    val price: Int,
    val sale: Int?,
    val brand: String?,
)
