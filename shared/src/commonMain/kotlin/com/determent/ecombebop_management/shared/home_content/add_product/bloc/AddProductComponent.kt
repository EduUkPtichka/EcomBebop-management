package com.determent.ecombebop_management.shared.home_content.add_product.bloc

import com.determent.ecombebop_management.shared.home_content.add_product.mvi.AddProductStore
import kotlinx.coroutines.flow.StateFlow

interface AddProductComponent {

    val model: StateFlow<AddProductStore.StateAddProduct>

    fun onCameraClicked()
    fun onGalleryClicked()

}