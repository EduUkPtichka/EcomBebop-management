package com.determent.ecombebop_management.shared.a_root.root_decompose

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.determent.ecombebop_management.shared.bottom_nav_screen.bloc.BottomNavScreenComponent

/*
 *   Использовать практику "управление объектом":
 * - factory method interface, с созданием объекта только через тип интерфейса
 * - singleton interface.
 */

interface RootComponent {

    val childRootStack: Value<ChildStack<*, ChildRoot>>

    sealed class ChildRoot {
        class BottomNavScreenChildRoot(val component: BottomNavScreenComponent) : ChildRoot()
    }

}