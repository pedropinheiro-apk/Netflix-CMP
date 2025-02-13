@file:Suppress("UnstableApiUsage")
plugins {
    id("com.streamplayer.kmp-library")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
        }
        commonMain.dependencies {
            implementation(projects.coreShared)

            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)

            implementation(libs.navigation.compose)

            implementation(libs.android.youtube.player)

            implementation(libs.coil)

            implementation(libs.paging.compose)
        }
    }
}

compose.resources {
    publicResClass = true
}
