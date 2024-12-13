@file:Suppress("UnstableApiUsage")

plugins {
    id("com.streamplayer.android-library")
    id("kotlin-android")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(projects.coreNetworking)
    implementation(projects.coreNavigation)
    implementation(projects.coreShared)
    implementation(projects.coreSharedUi)
    implementation(libs.navigation.compose)
    implementation(compose.material3)
    implementation(compose.ui)

    implementation(libs.bundles.koin)
    implementation(libs.koin.annotations)
    ksp(libs.koin.compiler)

    implementation(libs.bundles.networking)
    implementation(libs.bundles.androidSupport)
    implementation(libs.coil)

    testImplementation(libs.bundles.test)
}

ksp {
    arg("KOIN_CONFIG_CHECK","true")
}
