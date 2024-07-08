package com.determent.ecombebop_management.android

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.determent.ecombebop_management.shared.home.bloc.DefaultHomeComponent
import com.determent.ecombebop_management.shared.home_content.add_product.bloc.AddProductComponent
import com.determent.ecombebop_management.shared.home_content.add_product.bloc.DefaultAddProductComponent

class DefaultBottomNavScreenComponent(
    componentContext: ComponentContext,
    private val homeComponentFactory: (ComponentContext, () -> Unit) -> DefaultHomeComponent,
    private val addProductComponentFactory: (ComponentContext, () -> Unit, () -> Unit) -> AddProductComponent
) {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory,
    ) : this(
        componentContext = componentContext,
        homeComponentFactory = { childContext, onAddProductClicked ->
            DefaultHomeComponent(
                componentContext = childContext,
                storeFactory = storeFactory,
                onAddProductClicked = { onAddProductClicked() }
            )
        },
        addProductComponentFactory = { childContext, onCameraClicked, onGalleryClicked ->
            DefaultAddProductComponent(
                componentContext = childContext,
                storeFactory = storeFactory,
                callbackOpenCamera = { onCameraClicked() },
                callbackOpenGallery = { onGalleryClicked() },
            )
        }
    )
}