package com.determent.ecombebop_management.shared.bottom_nav_screen.bloc

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.determent.ecombebop_management.shared.bottom_nav_screen.bloc.BottomNavScreenComponent.BottomNavScreenModel
import com.determent.ecombebop_management.shared.bottom_nav_screen.bloc.DefaultBottomNavScreenComponent.ConfigBottomNavScreen.ConfigAddProduct
import com.determent.ecombebop_management.shared.bottom_nav_screen.bloc.DefaultBottomNavScreenComponent.ConfigBottomNavScreen.ConfigCatalog
import com.determent.ecombebop_management.shared.bottom_nav_screen.bloc.DefaultBottomNavScreenComponent.ConfigBottomNavScreen.ConfigHome
import com.determent.ecombebop_management.shared.bottom_nav_screen.bloc.DefaultBottomNavScreenComponent.ConfigBottomNavScreen.ConfigMessenger
import com.determent.ecombebop_management.shared.home_content.add_product.bloc.AddProductComponent
import com.determent.ecombebop_management.shared.home_content.add_product.bloc.DefaultAddProductComponent
import com.determent.ecombebop_management.shared.catalog.bloc.CatalogComponent
import com.determent.ecombebop_management.shared.catalog.bloc.DefaultCatalogComponent
import com.determent.ecombebop_management.shared.home.bloc.DefaultHomeComponent
import com.determent.ecombebop_management.shared.messenger.bloc.DefaultMessengerComponent
import com.determent.ecombebop_management.shared.messenger.bloc.MessengerComponent
import dev.icerock.moko.resources.compose.painterResource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.Serializable
import org.example.library.MR

class DefaultBottomNavScreenComponent(
    componentContext: ComponentContext,
    private val homeComponentFactory: (ComponentContext, () -> Unit) -> DefaultHomeComponent,
    private val addProductComponentFactory: (ComponentContext, () -> Unit, () -> Unit) -> AddProductComponent
) : BottomNavScreenComponent, ComponentContext by componentContext {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory,
    ) : this(
        componentContext = componentContext,
        homeComponentFactory = { childContext, onAddProductClicked ->
            DefaultHomeComponent(
                componentContext = childContext,
                storeFactory = storeFactory,
                onAddProductClicked = { onAddProductClicked() }
            )
        },
        addProductComponentFactory = { childContext, onCameraClicked, onGalleryClicked ->
            DefaultAddProductComponent(
                componentContext = childContext,
                storeFactory = storeFactory,
                callbackOpenCamera = { onCameraClicked() },
                callbackOpenGallery = { onGalleryClicked() },
            )
        }
    )

    private val navigationBottomNavScreen: StackNavigation<ConfigBottomNavScreen> = StackNavigation()

    override val childStackBottomNavScreen: Value<ChildStack<*, BottomNavScreenComponent.ChildBottomNavScreen>>
        get() = _childStackBottomNavScreen

    private val _childStackBottomNavScreen: Value<ChildStack<*, BottomNavScreenComponent.ChildBottomNavScreen>> =
        childStack(
            source = navigationBottomNavScreen,
            serializer = ConfigBottomNavScreen.serializer(),
            initialConfiguration = ConfigHome,
            key = "DefaultBottomNavScreenComponent",
            handleBackButton = true,
            childFactory = ::childFactoryBottomNavScreen
        )


    override val model: StateFlow<List<BottomNavScreenModel>>
        get() = _model.asStateFlow()

    private val _model: MutableStateFlow<List<BottomNavScreenModel>> = MutableStateFlow(
        listOf(
            BottomNavScreenModel(
                selectedIcon = { painterResource(MR.images.svg_home) },
                onSelectedScreen = ::onHomeClicked,
                isSelected = false,
            ),
            BottomNavScreenModel(
                selectedIcon = { painterResource(MR.images.svg_catalog_plus) },
                onSelectedScreen = ::onCatalogClicked,
                isSelected = false,
            ),
            BottomNavScreenModel(
                selectedIcon = { painterResource(MR.images.svg_chat) },
                onSelectedScreen = ::onMessengerClicked,
                isSelected = false,
            ),
        )
    )

    init {

    }

    private fun childFactoryBottomNavScreen(
        config: ConfigBottomNavScreen,
        componentContext: ComponentContext
    ): BottomNavScreenComponent.ChildBottomNavScreen {
        return when (config) {
            is ConfigHome -> BottomNavScreenComponent.ChildBottomNavScreen.HomeChildBottomNavScreen(
                component = homeComponentFactory(componentContext, ::onOpenAddProduct)
            )

            is ConfigCatalog -> BottomNavScreenComponent.ChildBottomNavScreen.CatalogChildBottomNavScreen(
                component = catalogComponent(componentContext)
            )

            is ConfigMessenger -> BottomNavScreenComponent.ChildBottomNavScreen.MessengerChildBottomNavScreen(
                component = messengerComponent(componentContext)
            )

            is ConfigAddProduct -> BottomNavScreenComponent.ChildBottomNavScreen.AddProductChildBottomNavScreen(
                component = addProductComponentFactory(componentContext, ::onCameraClicked, ::onGalleryClicked)
            )
        }
    }

    override fun onHomeClicked() {
        navigationBottomNavScreen.bringToFront(ConfigHome)
    }

    override fun onCatalogClicked() {
        navigationBottomNavScreen.bringToFront(ConfigCatalog)
    }

    override fun onMessengerClicked() {
        navigationBottomNavScreen.bringToFront(ConfigMessenger)
    }

    private fun onOpenAddProduct() {
        navigationBottomNavScreen.bringToFront(ConfigAddProduct)
    }

    private fun onCameraClicked() {

    }

    private fun onGalleryClicked() {

    }

    private fun catalogComponent(componentContext: ComponentContext): CatalogComponent {
        return DefaultCatalogComponent(componentContext = componentContext)
    }

    private fun messengerComponent(componentContext: ComponentContext): MessengerComponent {
        return DefaultMessengerComponent(componentContext = componentContext)
    }

    @Serializable
    private sealed interface ConfigBottomNavScreen {

        @Serializable
        data object ConfigHome : ConfigBottomNavScreen

        @Serializable
        data object ConfigCatalog : ConfigBottomNavScreen

        @Serializable
        data object ConfigMessenger : ConfigBottomNavScreen

        @Serializable
        data object ConfigAddProduct : ConfigBottomNavScreen
    }

}
