@file:Suppress("UnstableApiUsage")
plugins {
    id("com.streamplayer.android-library")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

dependencies {
    implementation(projects.coreShared)
    implementation(compose.material3)
    implementation(compose.preview)
    implementation(compose.ui)
    implementation(libs.navigation.compose)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.androidSupport)
    implementation(libs.android.youtube.player)
    implementation(libs.paging.compose)
    implementation(libs.coil)
    testImplementation(libs.bundles.test)
}