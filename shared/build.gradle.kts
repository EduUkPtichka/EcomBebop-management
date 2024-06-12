plugins {
    alias(libs.plugins.androidLibrary)
    //alias(libs.plugins.google.ksp)

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

            export(libs.arkivanov.decompose)
            export(libs.arkivanov.essenty.lifecycle)
            export(libs.arkivanov.essenty.stateKeeper)

            export(libs.moko.resources)
            export(libs.moko.graphics)

        }
    }

    sourceSets {
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

dependencies {
    /* ------- Compose multiplatform -------  */
    // Compose Multiplatform
    commonMainImplementation(libs.jetbrains.composeRuntime)
    commonMainImplementation(libs.jetbrains.composeFoundation)
    commonMainImplementation(libs.jetbrains.composeMaterial)
    commonMainImplementation(libs.jetbrains.composeUi)

    /* ------------ Compose Lib Multiplatform ------------  */
    // Haze
    commonMainImplementation(libs.chrisbanes.hazeJetpackCompose)
    commonMainImplementation(libs.chrisbanes.hazeMaterials)
    // Coil
    commonMainImplementation(libs.coil.compose)
    commonMainImplementation(libs.coil.compose.core)
    commonMainImplementation(libs.coil.network.ktor)
    commonMainImplementation(libs.coil.mp)

    /* ------------- Jetbrains ------------  */
    // Coroutines
    commonMainApi(libs.jetbrains.kotlinx.coroutines.core)

    commonMainImplementation(libs.jetbrains.kotlinxCollectionsImmutable)
    commonMainImplementation(libs.jetbrains.kotlinx.serialization.json)

    // Jetbrains Ktor-Client
    commonMainImplementation(libs.ktor.client.core)

    /* ------------- Arkivanov ------------ */
    // Decompose
    commonMainApi(libs.arkivanov.decompose)
    commonMainApi(libs.arkivanov.decompose.extensionsCompose)

    // MVI
    commonMainApi(libs.arkivanov.mvikotlin)
    commonMainApi(libs.arkivanov.mvikotlinMain)
    commonMainApi(libs.arkivanov.mvikotlinExtensionsCoroutines)
    commonMainApi(libs.arkivanov.mvikotlinLogger)
    commonMainApi(libs.arkivanov.mvikotlinTimetravel)

    // Kodein (DI)
    commonMainImplementation(libs.kodein.di)

    /* --------- Инфраструктурные -------- */
    // Touchlab
    commonMainImplementation(libs.touchlab.skie.configurationAnnotations)

    // Mako
    commonMainApi(libs.moko.resources)
    commonMainApi(libs.moko.resourcesCompose)

    /* --------------------- AndroidMain --------------------- */

    /* ------------ Compose Lib Android ------------  */
    // Camera
    "androidMainApi"(libs.androidx.camera.camera2)
    "androidMainApi"(libs.androidx.camera.core)
    "androidMainApi"(libs.androidx.camera.lifecycle)
    "androidMainApi"(libs.androidx.camera.view)
    "androidMainApi"(libs.androidx.camera.extensions)
    "androidMainApi"(libs.androidx.lifecycleRuntimeKtx)
    // ViewModel
    "androidMainApi"(libs.androidx.lifecycleViewModelCompose)
    // Permissions
    "androidMainApi"(libs.accompanist.permissions)

    /* ------------- Jetbrains ------------  */
    // Coroutines
    "androidMainImplementation"(libs.jetbrains.kotlinx.coroutines.core)
    "androidMainImplementation"(libs.jetbrains.kotlinx.coroutines.android)



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