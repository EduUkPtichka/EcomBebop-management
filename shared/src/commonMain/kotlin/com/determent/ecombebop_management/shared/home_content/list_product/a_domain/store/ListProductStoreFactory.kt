package com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.model.ProductItem
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.repository.ProductItemRepository
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.IntentListProduct
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.IntentListProduct.IntentListProductClickedAddProduct
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.IntentListProduct.IntentListProductItemClickedProduct
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.LabelListProduct
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.store.ListProductStore.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListProductStoreFactory(
    private val storeFactory: StoreFactory,
    private val productItemRepository: ProductItemRepository
) {

    fun create(): ListProductStore {
        return object : ListProductStore, Store<IntentListProduct, State, LabelListProduct> by storeFactory.create(
            name = "ListProductItemStore",
            initialState = State(),
            bootstrapper = BootstrapperImpl(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}
    }

    private sealed interface Action {
        data class ListProductLoaded(val listProduct: List<ProductItem>) : Action
    }

    private inner class BootstrapperImpl : CoroutineBootstrapper<Action>() {
        // invoke ---> executeAction
        override fun invoke() {
            scope.launch {
                productItemRepository.getListProductItem().collect {
                    dispatch(Action.ListProductLoaded(it))
                }
            }
        }
    }


    private inner class ExecutorImpl : CoroutineExecutor<IntentListProduct, Action, State, Msg, LabelListProduct>(
        mainContext = Dispatchers.Main
    ) {
        override fun executeAction(action: Action) {
            when (action) {
                is Action.ListProductLoaded -> {
                    dispatch(Msg.ListProductLoaded(action.listProduct))
                }
            }
        }

        override fun executeIntent(intent: IntentListProduct) {
            when (intent) {
                is IntentListProductClickedAddProduct -> {
                    publish(LabelListProduct.CallbackOpenAddProductContent)
                }

                is IntentListProductItemClickedProduct -> TODO()

            }
        }
    }

    private sealed interface Msg {
        data class ListProductLoaded(val listProduct: List<ProductItem>) : Msg
    }

    private object ReducerImpl : Reducer<State, Msg> {
        override fun State.reduce(msg: Msg): State {
            return when (msg) {
                is Msg.ListProductLoaded -> {
                    copy(listProduct = msg.listProduct)
                }
            }
        }
    }

}
