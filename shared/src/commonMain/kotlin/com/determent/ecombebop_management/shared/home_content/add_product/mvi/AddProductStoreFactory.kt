package com.determent.ecombebop_management.shared.home_content.add_product.mvi

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.determent.ecombebop_management.shared.home_content.add_product.mvi.AddProductStore.IntentAddProduct
import com.determent.ecombebop_management.shared.home_content.add_product.mvi.AddProductStore.LabelAddProduct
import com.determent.ecombebop_management.shared.home_content.add_product.mvi.AddProductStore.StateAddProduct

class AddProductStoreFactory(
    private val storeFactory: StoreFactory,
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

        }

    }

    private inner class ExecutorImpl : CoroutineExecutor<IntentAddProduct, Action, StateAddProduct, Msg, LabelAddProduct>() {

        override fun executeIntent(intent: IntentAddProduct) {
            when (intent) {
                IntentAddProduct.IntentOnClickedCamera -> {
                    publish(LabelAddProduct.LabelOnClickedCamera)
                }

                IntentAddProduct.IntentOnClickedGallery -> {
                    publish(LabelAddProduct.LabelOnClickedGallery)
                }
            }

        }

        override fun executeAction(action: Action) {

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