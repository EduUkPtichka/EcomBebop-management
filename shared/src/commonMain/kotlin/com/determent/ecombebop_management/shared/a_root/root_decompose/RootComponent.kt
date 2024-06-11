package com.determent.ecombebop_management.shared.a_root.root_decompose

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_domain.decompose.BottomNavScreenComponent

/*
 *   Использовать практику "управление объектом":
 * - factory method interface, с созданием объекта только через тип интерфейса
 * - singleton interface.
 */

interface RootComponent {

    val rootStack: Value<ChildStack<*, RootChild>>

    sealed class RootChild {
        class BottomNavScreen(val component: BottomNavScreenComponent) : RootChild()
    }
}