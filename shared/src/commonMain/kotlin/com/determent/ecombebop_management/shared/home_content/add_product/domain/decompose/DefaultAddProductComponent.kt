package com.determent.ecombebop_management.shared.home_content.add_product.domain.decompose

import com.arkivanov.decompose.ComponentContext
import com.determent.ecombebop_management.shared.home_content.add_product.domain.store.AddProductStore
import kotlinx.coroutines.flow.StateFlow

class DefaultAddProductComponent(
    componentContext: ComponentContext
) : AddProductComponent, ComponentContext by componentContext {

    override val model: StateFlow<AddProductStore.StateAddProduct>
        get() = TODO("Not yet implemented")


}