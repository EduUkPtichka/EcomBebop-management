package com.determent.ecombebop_management.shared.home_content.add_product.domain.decompose

import com.determent.ecombebop_management.shared.home_content.add_product.domain.store.AddProductStore
import kotlinx.coroutines.flow.StateFlow

interface AddProductComponent {

    val model: StateFlow<AddProductStore.StateAddProduct>

}