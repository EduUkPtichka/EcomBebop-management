package com.determent.ecombebop_management.shared.messenger.a_domain.decompose

import com.arkivanov.decompose.ComponentContext

class DefaultMessengerComponent(
    componentContext: ComponentContext
) : MessengerComponent, ComponentContext by componentContext {
}