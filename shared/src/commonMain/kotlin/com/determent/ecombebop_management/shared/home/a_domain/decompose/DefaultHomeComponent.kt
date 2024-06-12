package com.determent.ecombebop_management.shared.home.a_domain.decompose

import com.arkivanov.decompose.ComponentContext

class DefaultHomeComponent(
    componentContext: ComponentContext
) : HomeComponent, ComponentContext by componentContext {
}