@file:Suppress("UnstableApiUsage")

plugins {
    id("com.streamplayer.kmp-library")
    alias(libs.plugins.ksp)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.koin.annotations)
            implementation(libs.koin.core)
            implementation(projects.coreNetworking)
            implementation(projects.coreNavigation)
            implementation(projects.coreShared)
            implementation(projects.coreSharedUi)
            implementation(projects.coreLocalStorage)

            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.preview)
            implementation(libs.navigation.compose)
            implementation(libs.bundles.koin)
            implementation(libs.bundles.networking)
            implementation(libs.coil)
            api(libs.koin.annotations)
            implementation(libs.bundles.androidSupport)
        }
        commonTest.dependencies {
            implementation(libs.bundles.test)
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
    add("kspAndroid", libs.koin.ksp.compiler)
// add after with iOS
//    add("kspIosX64", libs.koin.ksp.compiler)
//    add("kspIosArm64", libs.koin.ksp.compiler)
//    add("kspIosSimulatorArm64", libs.koin.ksp.compiler)
}

ksp {
    arg("KOIN_CONFIG_CHECK","true")
}