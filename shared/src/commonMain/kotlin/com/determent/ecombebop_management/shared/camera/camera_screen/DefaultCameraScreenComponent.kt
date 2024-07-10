package com.determent.ecombebop_management.shared.camera.camera_screen

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.determent.ecombebop_management.shared.camera.camera_screen.CameraScreenComponent.Child
import com.determent.ecombebop_management.shared.camera.camera_screen.CameraScreenComponent.Child.CameraTakePictureChild
import com.determent.ecombebop_management.shared.camera.camera_take_picture.CameraTakePhotoComponent
import com.determent.ecombebop_management.shared.camera.camera_take_picture.DefaultCameraTakePhotoComponent
import kotlinx.serialization.Serializable

class DefaultCameraScreenComponent(
    componentContext: ComponentContext
) : CameraScreenComponent, ComponentContext by componentContext {

    private val navigation: StackNavigation<Config> = StackNavigation()

    private val _stack: Value<ChildStack<*, Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.ConfigCameraTakePicture,
            childFactory = ::child,
        )

    override val stack: Value<ChildStack<*, Child>> = _stack

    private fun child(config: Config, componentContext: ComponentContext): Child {
        return when (config) {
            Config.ConfigCameraTakePicture -> {
                CameraTakePictureChild(component = cameraTakePicture(componentContext))
            }
        }
    }

    private fun cameraTakePicture(componentContext: ComponentContext): CameraTakePhotoComponent {
        return DefaultCameraTakePhotoComponent(
            componentContext = componentContext
        )
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object ConfigCameraTakePicture : Config
    }

}