//
//  MutableValue.swift
//  iosApp
//
//  Created by Элдияр Укенов on 12.06.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import shared

func mutableValue<T: AnyObject>(_ initialValue: T) -> MutableValue<T> {
    return MutableValueBuilderKt.MutableValue(initialValue: initialValue) as! MutableValue<T>
}
