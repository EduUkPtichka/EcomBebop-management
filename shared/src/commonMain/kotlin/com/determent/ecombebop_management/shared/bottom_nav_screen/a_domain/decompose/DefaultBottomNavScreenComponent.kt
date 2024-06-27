package com.determent.ecombebop_management.shared.bottom_nav_screen.a_domain.decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_domain.decompose.BottomNavScreenComponent.BottomNavScreenModel
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_domain.decompose.DefaultBottomNavScreenComponent.ConfigBottomNavScreen.ConfigCatalog
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_domain.decompose.DefaultBottomNavScreenComponent.ConfigBottomNavScreen.ConfigHome
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_domain.decompose.DefaultBottomNavScreenComponent.ConfigBottomNavScreen.ConfigMessenger
import com.determent.ecombebop_management.shared.catalog.a_domain.decompose.CatalogComponent
import com.determent.ecombebop_management.shared.catalog.a_domain.decompose.DefaultCatalogComponent
import com.determent.ecombebop_management.shared.home.a_domain.decompose.DefaultHomeComponent
import com.determent.ecombebop_management.shared.home.a_domain.decompose.HomeComponent
import com.determent.ecombebop_management.shared.messenger.a_domain.decompose.DefaultMessengerComponent
import com.determent.ecombebop_management.shared.messenger.a_domain.decompose.MessengerComponent
import dev.icerock.moko.resources.compose.painterResource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.Serializable
import org.example.library.MR

class DefaultBottomNavScreenComponent(
    componentContext: ComponentContext,
    private val homeComponentLambda: (ComponentContext) -> DefaultHomeComponent,
) : BottomNavScreenComponent, ComponentContext by componentContext {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory,
    ) : this(
        componentContext = componentContext,
        homeComponentLambda = {
            DefaultHomeComponent(
                componentContext = componentContext,
                storeFactory = storeFactory,
            )
        }
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

    init {

    }

    private fun childFactoryBottomNavScreen(
        config: ConfigBottomNavScreen,
        componentContext: ComponentContext
    ): BottomNavScreenComponent.ChildBottomNavScreen {
        return when (config) {
            is ConfigHome -> BottomNavScreenComponent.ChildBottomNavScreen.HomeChildBottomNavScreen(
                component = homeComponentLambda(componentContext)
            )

            is ConfigCatalog -> BottomNavScreenComponent.ChildBottomNavScreen.CatalogChildBottomNavScreen(
                component = catalogComponent(componentContext)
            )

            ConfigMessenger -> BottomNavScreenComponent.ChildBottomNavScreen.MessengerChildBottomNavScreen(
                component = messengerComponent(componentContext)
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

//    private fun homeComponent(componentContext: ComponentContext): HomeComponent {
//        return homeComponentLambda(componentContext)
//    }

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
    }

}