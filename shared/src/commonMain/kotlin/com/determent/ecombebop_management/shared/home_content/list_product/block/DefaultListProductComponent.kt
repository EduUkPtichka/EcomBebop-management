package com.determent.ecombebop_management.shared.home_content.list_product.block

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.determent.ecombebop_management.shared.home_content.list_product.repository.ProductItemRepositoryImpl
import com.determent.ecombebop_management.shared.home_content.list_product.mvi.ListProductStore
import com.determent.ecombebop_management.shared.home_content.list_product.mvi.ListProductStoreFactory
import com.determent.ecombebop_management.shared.util.decompose_util.componentCoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DefaultListProductComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    private val onAddProductClicked: () -> Unit
) : ListProductComponent, ComponentContext by componentContext {

    private val componentCoroutineScope = componentCoroutineScope()

    private val storeFactoryListProduct = instanceKeeper.getStore {
        ListProductStoreFactory(
            storeFactory = storeFactory,
            productItemRepository = ProductItemRepositoryImpl()
        ).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<ListProductStore.StateListProduct>
        get() = storeFactoryListProduct.stateFlow

    init {
        componentCoroutineScope.launch {
            storeFactoryListProduct.labels.collect {
                when (it) {
                    ListProductStore.LabelListProduct.LabelOpenAddProduct -> {
                        onAddProductClicked()
                    }
                }
            }
        }
    }

    override fun onClickedAddProduct() {
        storeFactoryListProduct.accept(ListProductStore.IntentListProduct.IntentClickedAddProduct)
    }

    override fun onClickedProductItem(indexItem: Long) {

    }

}