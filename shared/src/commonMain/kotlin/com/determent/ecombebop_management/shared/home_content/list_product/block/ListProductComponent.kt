package com.determent.ecombebop_management.shared.home_content.list_product.block

import com.determent.ecombebop_management.shared.home_content.list_product.mvi.ListProductStore
import kotlinx.coroutines.flow.StateFlow

interface ListProductComponent {

    val model: StateFlow<ListProductStore.StateListProduct>

    fun onClickedAddProduct()
    fun onClickedProductItem(indexItem: Long)
}
