@file:Suppress("UnstableApiUsage")

plugins {
    id("com.streamplayer.kmp-library")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.paging.compose)

            implementation(projects.coreNetworking)
            implementation(projects.coreNavigation)
            implementation(projects.coreShared)
            implementation(projects.coreSharedUi)
            implementation(projects.coreLocalStorage)

            implementation(compose.components.resources)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.preview)

            implementation(libs.navigation.compose)
            
            implementation(libs.coil)

            implementation(libs.ktor.client.content.serialization.json)
            implementation(libs.ktor.client.content.negotiation)

            implementation(libs.koin.core)
            implementation(libs.koin.compose)
        }
    }
}