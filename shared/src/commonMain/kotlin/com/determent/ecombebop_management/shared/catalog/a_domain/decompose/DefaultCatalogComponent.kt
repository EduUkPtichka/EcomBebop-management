package com.determent.ecombebop_management.shared.catalog.a_domain.decompose

import com.arkivanov.decompose.ComponentContext

class DefaultCatalogComponent(
    componentContext: ComponentContext
) : CatalogComponent, ComponentContext by componentContext {
}