plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrains.kotlinMultiplatform)
    alias(libs.plugins.jetbrains.composeMultiplatform)
    alias(libs.plugins.jetbrains.kotlinCocoapods)
    alias(libs.plugins.jetbrains.kotlinPluginSerialization)
    alias(libs.plugins.touchlab.skiePlugin)
    alias(libs.plugins.icerock.mokoMobileMultiplatformResources)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"

            // Decompose
            export(libs.arkivanov.decompose)
            export(libs.arkivanov.essenty.lifecycle)
            export(libs.arkivanov.essenty.stateKeeper)

            // MVI
            export(libs.arkivanov.mvikotlin)
            export(libs.arkivanov.mvikotlinMain)
            export(libs.arkivanov.mvikotlinExtensionsCoroutines)
            export(libs.arkivanov.mvikotlinLogger)
            export(libs.arkivanov.mvikotlinTimetravel)

            // Ktor
            export(libs.ktor.client.darwin)

            // Resource
            export(libs.moko.resources)
            export(libs.moko.graphics)

        }
    }
}

dependencies {

    // Compose Multiplatform
    commonMainImplementation(libs.jetbrains.composeRuntime)
    commonMainImplementation(libs.jetbrains.composeFoundation)
    commonMainImplementation(libs.jetbrains.composeMaterial)
    commonMainImplementation(libs.jetbrains.composeUi)

    // Coil
    commonMainApi(libs.coil.compose)
    commonMainApi(libs.coil.compose.core)
    commonMainApi(libs.coil.network.ktor)
    commonMainApi(libs.coil.mp)

    // Coroutines
    commonMainApi(libs.jetbrains.kotlinx.coroutines.core)

    // Collection Immutable
    commonMainApi(libs.jetbrains.kotlinxCollectionsImmutable)

    // KotlinX Json
    commonMainApi(libs.jetbrains.kotlinx.serialization.json)

    // Jetbrains Ktor-Client
    commonMainImplementation(libs.ktor.client.core)

    // Decompose
    commonMainApi(libs.arkivanov.decompose)
    commonMainApi(libs.arkivanov.decompose.extensionsCompose)

    // MVI
    commonMainApi(libs.arkivanov.mvikotlin)
    commonMainApi(libs.arkivanov.mvikotlinMain)
    commonMainApi(libs.arkivanov.mvikotlinExtensionsCoroutines)
    commonMainApi(libs.arkivanov.mvikotlinLogger)
    commonMainApi(libs.arkivanov.mvikotlinTimetravel)

    // Koin
    commonMainApi(libs.koin.core)
    commonMainApi(libs.koin.compose)

    // Touchlab
    commonMainImplementation(libs.touchlab.skie.configurationAnnotations)

    // Moko
    commonMainApi(libs.moko.resources)
    commonMainApi(libs.moko.resourcesCompose)

    /* --------------------- AndroidMain --------------------- */

    "androidMainImplementation"(libs.androidx.activity.compose)
    "androidMainApi"(libs.accompanist.permissions)

    "androidMainApi"(libs.androidx.camera.core)
    "androidMainApi"(libs.androidx.camera.camera2)
    "androidMainApi"(libs.androidx.camera.lifecycle)
    "androidMainApi"(libs.androidx.camera.view)

    // Coroutines
    "androidMainApi"(libs.jetbrains.kotlinx.coroutines.core)
    "androidMainApi"(libs.jetbrains.kotlinx.coroutines.android)

    // Ktor
    "androidMainApi"(libs.ktor.client.okhttp)

    // Koin
    "androidMainApi"(libs.koin.android)

    "androidMainImplementation"(libs.android.composeUiToolingPreview)
}

android {
    namespace = "com.determent.ecombebop_management.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.version.get()
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(libs.android.composeUiTooling)
    }
}

multiplatformResources {
    resourcesPackage.set("org.example.library")
}