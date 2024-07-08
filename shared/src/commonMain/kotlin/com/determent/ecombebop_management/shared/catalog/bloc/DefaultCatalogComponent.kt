package com.determent.ecombebop_management.shared.catalog.bloc

import com.arkivanov.decompose.ComponentContext

class DefaultCatalogComponent(
    componentContext: ComponentContext
) : CatalogComponent, ComponentContext by componentContext {
}