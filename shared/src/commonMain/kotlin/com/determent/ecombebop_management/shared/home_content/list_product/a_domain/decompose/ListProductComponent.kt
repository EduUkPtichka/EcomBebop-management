package com.determent.ecombebop_management.shared.home_content.list_product.a_domain.decompose

import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore
import kotlinx.coroutines.flow.StateFlow

interface ListProductComponent {

    val model: StateFlow<ListProductStore.StateListProduct>

    fun onClickedAddProduct()
    fun onClickedProductItem(indexItem: Long)

}