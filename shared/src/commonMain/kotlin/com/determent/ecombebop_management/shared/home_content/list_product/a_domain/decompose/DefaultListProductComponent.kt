package com.determent.ecombebop_management.shared.home_content.list_product.a_domain.decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.repository.ProductItemRepositoryImpl
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow

class DefaultListProductComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
) : ListProductComponent, ComponentContext by componentContext {

    private val storeFactoryListProduct = instanceKeeper.getStore {
        ListProductStoreFactory(
            storeFactory = storeFactory,
            productItemRepository = ProductItemRepositoryImpl()
        ).create()
    }

    init {

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<ListProductStore.StateListProduct>
        get() = storeFactoryListProduct.stateFlow

    override fun onClickedAddProduct() {
        storeFactoryListProduct.accept(ListProductStore.IntentListProduct.IntentListProductClickedAddProduct)
    }

    override fun onClickedProductItem(indexItem: Long) {
        storeFactoryListProduct.accept(ListProductStore.IntentListProduct.IntentListProductItemClickedProduct(indexItem = indexItem))
    }

}