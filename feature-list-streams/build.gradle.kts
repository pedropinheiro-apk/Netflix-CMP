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
        commonMain.dependencies {
            implementation(libs.koin.annotations)
            implementation(libs.koin.core)
        }

        androidMain.dependencies {
            implementation(projects.coreNetworking)
            implementation(projects.coreNavigation)
            implementation(projects.coreShared)
            implementation(projects.coreSharedUi)
            implementation(projects.coreLocalStorage)

            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.preview)
            implementation(libs.paging.compose)
            implementation(libs.navigation.compose)
            implementation(libs.bundles.koin)
            implementation(libs.bundles.networking)
            implementation(libs.coil)
            implementation(libs.koin.annotations)
            implementation(libs.bundles.androidSupport)

        }

        sourceSets.named("androidMain").configure {
            kotlin.srcDir("build/generated/ksp/metadata/androidMain/kotlin")
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