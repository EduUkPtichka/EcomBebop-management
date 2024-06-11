package com.determent.ecombebop_management.shared.a_root.root_decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.determent.ecombebop_management.shared.a_root.root_decompose.DefaultRootComponent.RootConfig.BottomNavScreenRootConfig
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_domain.decompose.BottomNavScreenComponent
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_domain.decompose.DefaultBottomNavScreenComponent
import kotlinx.serialization.Serializable

/*
 *  Не стоит прибегать к использованию DI, на DefaultRootComponent, например DefaultBottomNavScreenComponent
 * можно внедрить используя DI, но это приведет к сложности переиспользования.
 *
 *   Думаю что не стоит использовать DI на уровне компонентов.
 * - multiplatform: отслеживание lifecycle DI.
 * - сложности при миграции от DI к DI: в multiplatform это частое явление "погоня за лучшим interop ability".
 * - переиспользуемость: как и внутренняя, так и наружная в других проектах.
 *
 *  !Используйте внутри у под компонентов!.
 */

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val rootNavigation: StackNavigation<RootConfig> = StackNavigation<RootConfig>()

    /*
     * Интересное поведение компилятора при указании полного объема типов:
     *
     * false: val rootStack: Value<ChildStack<*, RootComponent.RootChild>> = _rootStack
     * true:  val rootStack: Value<ChildStack<*, RootComponent.RootChild>>
     *             get() = _rootStack
     */
    override val rootStack: Value<ChildStack<*, RootComponent.RootChild>>
        get() = this._rootStack

    private val _rootStack: Value<ChildStack<*, RootComponent.RootChild>> = childStack(
        source = rootNavigation,
        serializer = RootConfig.serializer(),
        initialConfiguration = BottomNavScreenRootConfig,
        key = "DefaultRootComponent",
        handleBackButton = true,
        childFactory = ::rootChildFactory,
    )

    init {

    }

    private fun rootChildFactory(
        config: RootConfig,
        componentContext: ComponentContext
    ): RootComponent.RootChild {
        return when (config) {
            is BottomNavScreenRootConfig -> RootComponent.RootChild.BottomNavScreen(
                component = bottomNavScreenComponent(componentContext)
            )
        }
    }

    private fun bottomNavScreenComponent(componentContext: ComponentContext): BottomNavScreenComponent {
        return DefaultBottomNavScreenComponent(componentContext = componentContext)
    }


    @Serializable
    private sealed interface RootConfig {
        @Serializable
        data object BottomNavScreenRootConfig : RootConfig

    }
}