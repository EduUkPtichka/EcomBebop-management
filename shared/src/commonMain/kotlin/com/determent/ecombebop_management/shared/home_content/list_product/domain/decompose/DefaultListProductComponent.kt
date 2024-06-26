package com.determent.ecombebop_management.shared.home_content.list_product.domain.decompose

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class DefaultListProductComponent(
    componentContext: ComponentContext,
//    private val onAddProduct: (id: Long) -> Unit,
) : ListProductComponent, ComponentContext by componentContext {


    override fun onClickedAddProduct(id: Long) {
        //onAddProduct(id)
    }

    override val listProductItem: StateFlow<List<ListProductComponent.ProductItem>>
        get() = TODO("Not yet implemented")

}