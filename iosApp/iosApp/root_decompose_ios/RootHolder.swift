//
//  RootHolder.swift
//  iosApp
//
//  Created by Элдияр Укенов on 12.06.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

class RootHolder : ObservableObject {
    let lifecycle: LifecycleRegistry
    let storeFactory: StoreFactory
    let root: RootComponent

    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        
        storeFactory = DefaultStoreFactory()

        root = DefaultRootComponent(
            componentContext: DefaultComponentContext(lifecycle: lifecycle),
            storeFactory: storeFactory
        )

        LifecycleRegistryExtKt.create(lifecycle)
    }

    deinit {
        // Destroy the root component before it is deallocated
        LifecycleRegistryExtKt.destroy(lifecycle)
    }
}

