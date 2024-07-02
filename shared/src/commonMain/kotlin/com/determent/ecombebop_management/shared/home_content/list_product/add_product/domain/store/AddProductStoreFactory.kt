package com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.repository.AddProductRepository
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.store.AddProductStore.IntentAddProduct
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.store.AddProductStore.LabelAddProduct
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.store.AddProductStore.StateAddProduct

class AddProductStoreFactory(
    private val storeFactory: StoreFactory,
    private val addProductRepository: AddProductRepository
) {

    fun createAddProductStoreFactory(): AddProductStore {
        return object : AddProductStore, Store<IntentAddProduct, StateAddProduct, LabelAddProduct> by storeFactory.create(
            name = "AddProductStoreFactory",
            initialState = StateAddProduct(),
            bootstrapper = BootstrapperImpl(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}
    }

    private sealed interface Action {

    }

    private inner class BootstrapperImpl : CoroutineBootstrapper<Action>() {
        override fun invoke() {
            TODO("Not yet implemented")
        }

    }

    private inner class ExecutorImpl : CoroutineExecutor<IntentAddProduct, Action, StateAddProduct, Msg, LabelAddProduct>() {

        override fun executeAction(action: Action) {

        }

        override fun executeIntent(intent: IntentAddProduct) {

        }


    }

    private sealed interface Msg {

    }

    private object ReducerImpl : Reducer<StateAddProduct, Msg> {

        override fun StateAddProduct.reduce(msg: Msg): StateAddProduct {
            TODO("Not yet implemented")
        }

    }

}