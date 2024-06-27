package com.determent.ecombebop_management.shared.a_root.root_decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.determent.ecombebop_management.shared.a_root.root_decompose.DefaultRootComponent.ConfigRoot.ConfigRootBottomNavScreen
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
    componentContext: ComponentContext,
    private val bottomNavScreenComponentLambda: (ComponentContext) -> DefaultBottomNavScreenComponent,
) : RootComponent, ComponentContext by componentContext {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory
    ) : this(
        componentContext = componentContext,
        bottomNavScreenComponentLambda = {
            DefaultBottomNavScreenComponent(
                componentContext = componentContext,
                storeFactory = storeFactory
            )
        }
    )

    private val rootNavigation: StackNavigation<ConfigRoot> = StackNavigation()

    /*
     * Интересное поведение компилятора при указании полного объема типов:
     *
     * false: val rootStack: Value<ChildStack<*, RootComponent.RootChild>> = _rootStack
     * true:  val rootStack: Value<ChildStack<*, RootComponent.RootChild>>
     *             get() = _rootStack
     */
    override val childRootStack: Value<ChildStack<*, RootComponent.ChildRoot>>
        get() = this._childRootStack

    private val _childRootStack: Value<ChildStack<*, RootComponent.ChildRoot>> =
        childStack(
            source = rootNavigation,
            serializer = ConfigRoot.serializer(),
            initialConfiguration = ConfigRootBottomNavScreen,
            key = "DefaultRootComponent",
            handleBackButton = true,
            childFactory = ::childFactoryRoot,
        )

    init {

    }

    private fun childFactoryRoot(
        config: ConfigRoot,
        componentContext: ComponentContext
    ): RootComponent.ChildRoot {
        return when (config) {
            is ConfigRootBottomNavScreen -> RootComponent.ChildRoot.BottomNavScreenChildRoot(
                component = bottomNavScreenComponentLambda(componentContext)
            )
        }
    }

//    private fun bottomNavScreenComponent(componentContext: ComponentContext): BottomNavScreenComponent {
//        return DefaultBottomNavScreenComponent(componentContext = componentContext)
//    }


    @Serializable
    private sealed interface ConfigRoot {
        @Serializable
        data object ConfigRootBottomNavScreen : ConfigRoot

    }
}