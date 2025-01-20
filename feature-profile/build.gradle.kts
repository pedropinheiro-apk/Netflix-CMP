@file:Suppress("UnstableApiUsage")

plugins {
    id("com.streamplayer.kmp-library")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(projects.coreNetworking)
            implementation(projects.coreNavigation)
            implementation(projects.coreShared)
            implementation(projects.coreSharedUi)
            implementation(libs.navigation.compose)
            implementation(compose.material3)
            implementation(compose.ui)

            implementation(libs.bundles.koin)
            implementation(libs.koin.annotations)
            implementation(libs.bundles.networking)
            implementation(libs.bundles.androidSupport)
            implementation(libs.coil)

        }
    }
}

dependencies {
    add("kspCommonMainMetadata",libs.koin.compiler)
    add("kspAndroid", libs.koin.compiler)
}

ksp {
    arg("KOIN_CONFIG_CHECK","true")
}
