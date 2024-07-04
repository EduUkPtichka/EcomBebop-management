package com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store

import com.arkivanov.mvikotlin.core.store.Store
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.model.ProductItemModel
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.IntentListProduct
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.LabelListProduct
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.StateListProduct

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