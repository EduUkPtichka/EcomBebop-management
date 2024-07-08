package com.determent.ecombebop_management.shared.home.bloc

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.stop
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.determent.ecombebop_management.shared.home_content.list_product.block.DefaultListProductComponent

class DefaultHomeComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    private val onAddProductClicked: () -> Unit,
) : HomeComponent, ComponentContext by componentContext {

    private val counterLifecycle = LifecycleRegistry()

    override val childListProductComponent = DefaultListProductComponent(
        componentContext = childContext(
            key = "ListProductComponent",
            lifecycle = counterLifecycle
        ),
        storeFactory = storeFactory,
        onAddProductClicked = { onAddProductClicked() }
    )

    fun resumeCounter() {
        counterLifecycle.resume()
    }

    private fun stopCounter() {
        counterLifecycle.stop()
    }

}