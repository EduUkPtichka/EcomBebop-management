package com.determent.ecombebop_management.shared.bottom_nav_screen.ui_cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.determent.ecombebop_management.shared.bottom_nav_screen.BottomNavScreenComponent
import com.determent.ecombebop_management.shared.catalog.ui_cmp.CatalogContentScreen
import com.determent.ecombebop_management.shared.home.ui_cmp.HomeContentScreen
import com.determent.ecombebop_management.shared.home_content.add_product.ui_cmp.AddProductContent
import com.determent.ecombebop_management.shared.messenger.ui_cmp.MessengerContentScreen

/*
 * В будущем сделать рефакторинг, а именно перенести в ios(swift).
 * BottomNavContentScreen - как и RootContentScreen, содержит другие ContentScreen.
 *
 * selectedItem - поднять в BottomNavScreenComponent как отдельный observable state .
 */
@Composable
fun BottomNavContentScreen(
    component: BottomNavScreenComponent,
    modifier: Modifier = Modifier
) {

    val model by component.model.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNav(
                listItems = model,
            )
        }
    ) {
        Children(
            stack = component.childStackBottomNavScreen,
            modifier = modifier,
            animation = stackAnimation(fade()),
        ) {
            when (val childStackBottomNavScreen = it.instance) {
                is BottomNavScreenComponent.ChildBottomNavScreen.HomeChildBottomNavScreen -> HomeContentScreen(
                    component = childStackBottomNavScreen.component,
                    modifier = Modifier,
                )

                is BottomNavScreenComponent.ChildBottomNavScreen.CatalogChildBottomNavScreen -> CatalogContentScreen(
                    component = childStackBottomNavScreen.component,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Cyan)
                )

                is BottomNavScreenComponent.ChildBottomNavScreen.MessengerChildBottomNavScreen -> MessengerContentScreen(
                    component = childStackBottomNavScreen.component,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                )

                is BottomNavScreenComponent.ChildBottomNavScreen.AddProductChildBottomNavScreen -> AddProductContent(
                    component = childStackBottomNavScreen.component
                )
            }
        }

    }

}