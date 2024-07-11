@file:Suppress("UnstableApiUsage")

plugins {
    id("com.streamplayer.android-library")
    id("com.streamplayer.compose")
}

dependencies {
    implementation(projects.coreNetworking)
    implementation(projects.coreNavigation)
    implementation(projects.coreShared)
    implementation(projects.coreSharedUi)
    implementation(projects.coreLocalStorage)

    implementation(libs.bundles.koin)
    implementation(libs.bundles.networking)
    implementation(libs.roomRuntime)
    implementation(libs.bundles.androidSupport)
    implementation(libs.coil)

    testImplementation(libs.bundles.test)
}