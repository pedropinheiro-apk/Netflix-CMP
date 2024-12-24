@file:Suppress("UnstableApiUsage")
plugins {
    id("com.streamplayer.android-library")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.navigation.compose)
    implementation(compose.material3)
}