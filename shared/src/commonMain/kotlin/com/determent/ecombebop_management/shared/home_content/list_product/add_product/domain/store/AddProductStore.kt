package com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.store

import com.arkivanov.mvikotlin.core.store.Store
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.model.AddProductItemModel
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.store.AddProductStore.IntentAddProduct
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.store.AddProductStore.LabelAddProduct
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.store.AddProductStore.StateAddProduct

interface AddProductStore : Store<IntentAddProduct, StateAddProduct, LabelAddProduct> {

    data class StateAddProduct(
        val addItemProduct: AddProductItemModel = AddProductItemModel(),
    )

    sealed interface IntentAddProduct {
        data class EditTitle(val title: String) : IntentAddProduct
        data class EditPrise(val prise: String) : IntentAddProduct
        data class EditDiscount(val discount: String) : IntentAddProduct
    }

    sealed interface LabelAddProduct {
        data class LabelAddProductItem(val callbackPostAddProduct: AddProductItemModel)
    }

}