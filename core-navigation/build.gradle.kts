@file:Suppress("UnstableApiUsage")
plugins {
    id("com.streamplayer.kmp-library")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.navigation.compose)
            implementation(compose.material3)
            implementation(compose.components.resources)
            api(libs.androidx.navigation3.ui)
            api(libs.androidx.navigation3.runtime)
        }
    }
}