package com.determent.ecombebop_management.shared.home_content.list_product.add_product.store

import androidx.compose.ui.graphics.Color
import com.arkivanov.mvikotlin.core.store.Store
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.model.EnumClothesSize
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.store.AddProductStore.IntentAddProduct
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.store.AddProductStore.LabelAddProduct
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.store.AddProductStore.StateAddProduct

interface AddProductStore : Store<StateAddProduct, IntentAddProduct, LabelAddProduct> {

    data class StateAddProduct(
        val error: String,
        val mainImage: Byte,
        val othersImage: List<Byte>,
        val othersColorImage: List<Color>,
        val selectColor: List<String>,
        val editText: String,
        val prise: String,
        val discount: String,
        val priceCalculated: String,
    )

    sealed interface IntentAddProduct {
        data object ClickedOpenCamera : IntentAddProduct
        data object ClickedOpenGallery : IntentAddProduct
        data object OthersImage : IntentAddProduct
        data object OthersColorImage : IntentAddProduct
        data object SelectColor : IntentAddProduct
        data class SelectClothesSize(val listEnumClothesSize: List<EnumClothesSize>) : IntentAddProduct
        data class EditTitle(val title: String) : IntentAddProduct
        data class EditPrise(val prise: String) : IntentAddProduct
        data class EditDiscount(val discount: String) : IntentAddProduct
    }

    sealed interface LabelAddProduct {

    }


}