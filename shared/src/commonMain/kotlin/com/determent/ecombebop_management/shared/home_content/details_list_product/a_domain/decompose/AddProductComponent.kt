package com.determent.ecombebop_management.shared.home_content.details_list_product.a_domain.decompose

interface AddProductComponent {


    data class AddProductItem(
        val mainImage: Byte,
        val price: Int,
        val discount: Double,
        val title: String,
        val brand: String
    )


}