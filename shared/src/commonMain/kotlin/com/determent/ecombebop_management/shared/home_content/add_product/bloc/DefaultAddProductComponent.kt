package com.determent.ecombebop_management.shared.home_content.add_product.bloc

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.determent.ecombebop_management.shared.home_content.add_product.mvi.AddProductStore
import com.determent.ecombebop_management.shared.home_content.add_product.mvi.AddProductStoreFactory
import com.determent.ecombebop_management.shared.util.decompose_util.componentCoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DefaultAddProductComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    private val callbackOpenCamera: () -> Unit,
    private val callbackOpenGallery: () -> Unit,
) : AddProductComponent, ComponentContext by componentContext {

    private val componentCoroutineScope = componentCoroutineScope()

    private val storeFactoryAddProduct = instanceKeeper.getStore {
        AddProductStoreFactory(
            storeFactory = storeFactory,
        ).createAddProductStoreFactory()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<AddProductStore.StateAddProduct>
        get() = storeFactoryAddProduct.stateFlow

    init {
        componentCoroutineScope.launch {
            storeFactoryAddProduct.labels.collect {
                when (it) {
                    AddProductStore.LabelAddProduct.LabelOnClickedCamera -> {
                        callbackOpenCamera()
                    }

                    AddProductStore.LabelAddProduct.LabelOnClickedGallery -> {
                        callbackOpenGallery()
                    }
                }
            }
        }
    }

    override fun onCameraClicked() {
        storeFactoryAddProduct.accept(AddProductStore.IntentAddProduct.IntentOnClickedCamera)
    }

    override fun onGalleryClicked() {
        storeFactoryAddProduct.accept(AddProductStore.IntentAddProduct.IntentOnClickedGallery)
    }


}