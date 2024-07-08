package com.determent.ecombebop_management.shared.messenger.bloc

import com.arkivanov.decompose.ComponentContext

class DefaultMessengerComponent(
    componentContext: ComponentContext
) : MessengerComponent, ComponentContext by componentContext {
}