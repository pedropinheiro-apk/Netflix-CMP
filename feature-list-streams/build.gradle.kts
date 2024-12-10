@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget


plugins {
    id("com.streamplayer.android-library")
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(projects.coreNetworking)
            implementation(projects.coreNavigation)
            implementation(projects.coreShared)
            implementation(projects.coreSharedUi)
            implementation(projects.coreLocalStorage)
            implementation(libs.bundles.koin)
            implementation(libs.bundles.networking)
            implementation(libs.coil)
            implementation(libs.koin.annotations)
            implementation(libs.bundles.androidSupport)
        }
    }
}

ksp {
    arg("KOIN_CONFIG_CHECK","true")
}