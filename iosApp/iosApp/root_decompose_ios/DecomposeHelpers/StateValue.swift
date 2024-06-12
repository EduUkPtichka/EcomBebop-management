//
//  StateValue.swift
//  iosApp
//
//  Created by Элдияр Укенов on 12.06.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

@propertyWrapper struct StateValue<T : AnyObject>: DynamicProperty {
    @ObservedObject
    private var obj: ObservableValue<T>

    var wrappedValue: T { obj.value }

    init(_ value: Value<T>) {
        obj = ObservableValue(value)
    }
}
