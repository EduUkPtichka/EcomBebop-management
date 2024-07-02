package com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store

import com.arkivanov.mvikotlin.core.store.Store
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.model.ProductItem
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.IntentListProduct
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.LabelListProduct
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.StateListProduct

interface ListProductStore : Store<IntentListProduct, StateListProduct, LabelListProduct> {

    data class StateListProduct(
        val listProduct: List<ProductItem> = emptyList(),
        val isLoading: Boolean = false,
        val error: String = ""
    )

    sealed interface IntentListProduct {
        data object IntentListProductClickedAddProduct : IntentListProduct
        data class IntentListProductItemClickedProduct(val indexItem: Long) : IntentListProduct
    }


    sealed interface LabelListProduct {
        data object CallbackOpenAddProductContent : LabelListProduct
    }
}