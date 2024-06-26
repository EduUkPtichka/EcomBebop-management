package com.determent.ecombebop_management.shared.home_content.list_product.domain.decompose

import kotlinx.coroutines.flow.StateFlow

interface ListProductComponent {

    fun onClickedAddProduct(id: Long)

    /*
     * Плохая ли идея?
     * val listProductItem: StateFlow<List<ComposableTypeInList.ListProduct>>
     */
    val listProductItem: StateFlow<List<ProductItem>>

    data class ProductItem(
        val mainImage: Byte,
        val price: Int,
        val discount: Double,
        val title: String,
        val brand: String
    )

    /*
     * Плохая ли идея?
     * data class ListProduct(val model: StateFlow<List<ProductItem>>) : ComposableTypeInList(2)
     */
    sealed class ComposableTypeInList(val typeId: Int) {
        data object ManagerAddProduct : ComposableTypeInList(1)
        data object ListProduct : ComposableTypeInList(2)
    }
}