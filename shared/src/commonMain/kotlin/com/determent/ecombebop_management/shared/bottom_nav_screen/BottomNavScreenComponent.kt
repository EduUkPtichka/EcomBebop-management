package com.determent.ecombebop_management.shared.bottom_nav_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.determent.ecombebop_management.shared.catalog.bloc.CatalogComponent
import com.determent.ecombebop_management.shared.home.bloc.HomeComponent
import com.determent.ecombebop_management.shared.home_content.add_product.bloc.AddProductComponent
import com.determent.ecombebop_management.shared.messenger.bloc.MessengerComponent
import kotlinx.coroutines.flow.StateFlow

interface BottomNavScreenComponent {

    val childStackBottomNavScreen: Value<ChildStack<*, ChildBottomNavScreen>>

    val model: StateFlow<List<BottomNavScreenModel>>
    fun onHomeClicked()
    fun onCatalogClicked()
    fun onMessengerClicked()

    sealed class ChildBottomNavScreen {
        class HomeChildBottomNavScreen(val component: HomeComponent) : ChildBottomNavScreen()
        class CatalogChildBottomNavScreen(val component: CatalogComponent) : ChildBottomNavScreen()
        class MessengerChildBottomNavScreen(val component: MessengerComponent) : ChildBottomNavScreen()
        class AddProductChildBottomNavScreen(val component: AddProductComponent) : ChildBottomNavScreen()
    }

    data class BottomNavScreenModel(
        val title: String? = null,
        val contentDescription: String? = null,
        val selectedIcon: @Composable () -> Painter,
        val unselectedIcon: @Composable (() -> Painter)? = null,
        val onSelectedScreen: () -> Unit,
        val isSelected: Boolean,
        val badgeCount: Int? = null,
    )
}

