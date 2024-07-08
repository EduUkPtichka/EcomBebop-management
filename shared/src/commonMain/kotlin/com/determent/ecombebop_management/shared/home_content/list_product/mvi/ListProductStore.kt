package com.determent.ecombebop_management.shared.home_content.list_product.mvi

import com.arkivanov.mvikotlin.core.store.Store
import com.determent.ecombebop_management.shared.home_content.list_product.model.ProductItemModel
import com.determent.ecombebop_management.shared.home_content.list_product.mvi.ListProductStore.IntentListProduct
import com.determent.ecombebop_management.shared.home_content.list_product.mvi.ListProductStore.LabelListProduct
import com.determent.ecombebop_management.shared.home_content.list_product.mvi.ListProductStore.StateListProduct

interface ListProductStore : Store<IntentListProduct, StateListProduct, LabelListProduct> {

    data class StateListProduct(
        val listProduct: List<ProductItemModel> = emptyList(),
        val isLoading: Boolean = false,
        val error: String = ""
    )

    sealed interface IntentListProduct {
        data object IntentClickedAddProduct : IntentListProduct
    }


    sealed interface LabelListProduct {
        data object LabelOpenAddProduct : LabelListProduct
    }
}