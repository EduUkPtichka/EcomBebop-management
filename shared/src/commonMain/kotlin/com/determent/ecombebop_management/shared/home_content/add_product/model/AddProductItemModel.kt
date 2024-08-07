package com.determent.ecombebop_management.shared.home_content.add_product.model

data class AddProductItemModel(
    val mainImage: Byte = 0,
    val othersImage: List<Byte> = emptyList(),
    val productsColors: List<ColorsProduct> = emptyList(),
    val sizesClothes: List<SizesClothes> = emptyList(),
    val quantityProduct: List<Int> = emptyList(),
    val price: Int = 0,
    val discount: Int = 0,
    val priceCalculated: Int = 0,
    val title: String = "",
    val brand: String = "",
)

