package com.determent.ecombebop_management.shared.a_root.root_decompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_ui_cmp.BottomNavContentScreen

@Composable
fun RootContentScreen(component: RootComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.childRootStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val rootChildStack = it.instance) {
            is RootComponent.ChildRoot.BottomNavScreenChildRoot -> BottomNavContentScreen(component = rootChildStack.component)
        }
    }
}