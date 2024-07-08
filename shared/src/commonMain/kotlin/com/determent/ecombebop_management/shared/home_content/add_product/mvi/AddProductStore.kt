package com.determent.ecombebop_management.shared.home_content.add_product.mvi

import com.arkivanov.mvikotlin.core.store.Store
import com.determent.ecombebop_management.shared.home_content.add_product.model.AddProductItemModel
import com.determent.ecombebop_management.shared.home_content.add_product.model.ProductItemRelationItemModel
import com.determent.ecombebop_management.shared.home_content.add_product.mvi.AddProductStore.IntentAddProduct
import com.determent.ecombebop_management.shared.home_content.add_product.mvi.AddProductStore.LabelAddProduct
import com.determent.ecombebop_management.shared.home_content.add_product.mvi.AddProductStore.StateAddProduct

interface AddProductStore : Store<IntentAddProduct, StateAddProduct, LabelAddProduct> {

    data class StateAddProduct(
        val productItemRelation: ProductItemRelationItemModel = ProductItemRelationItemModel(),
        val addItemProduct: AddProductItemModel = AddProductItemModel(),
    )

    sealed interface IntentAddProduct {
        data object IntentOnClickedCamera : IntentAddProduct
        data object IntentOnClickedGallery : IntentAddProduct
    }

    sealed interface LabelAddProduct {
        data object LabelOnClickedCamera : LabelAddProduct
        data object LabelOnClickedGallery : LabelAddProduct
    }

}