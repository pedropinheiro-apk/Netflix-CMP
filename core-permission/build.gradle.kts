@file:Suppress("UnstableApiUsage")

plugins {
    id("com.streamplayer.kmp-library")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    sourceSets {
        sourceSets {
            androidMain.dependencies {
                implementation(compose.preview)
            }
            commonMain.dependencies {
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(libs.moko.permissions.core)
                api(libs.moko.permissions.compose)
                implementation(libs.moko.permissions.camera)
                implementation(libs.moko.permissions.gallery)
                implementation(compose.components.resources)
                implementation(libs.koin.core)
            }
        }
    }
}