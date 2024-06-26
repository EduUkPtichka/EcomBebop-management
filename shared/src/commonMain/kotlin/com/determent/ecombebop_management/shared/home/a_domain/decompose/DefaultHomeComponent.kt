package com.determent.ecombebop_management.shared.home.a_domain.decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.stop
import com.determent.ecombebop_management.shared.home_content.list_product.domain.decompose.DefaultListProductComponent
import com.determent.ecombebop_management.shared.home_content.list_product.domain.decompose.ListProductComponent

class DefaultHomeComponent(
    componentContext: ComponentContext
) : HomeComponent, ComponentContext by componentContext {

    private val counterLifecycle = LifecycleRegistry()

    val listProductComponent: ListProductComponent =
        DefaultListProductComponent(
            componentContext = childContext(
                key = "ListProductComponent",
                lifecycle = counterLifecycle
            )
        )

    private fun resumeCounter() {
        counterLifecycle.resume()
    }

    private fun stopCounter() {
        counterLifecycle.stop()
    }

}