plugins {
    id("com.streamplayer.kmp-library")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

android {
    buildFeatures {
        buildConfig = true
    }
    buildTypes {
        debug {
            buildConfigField("String", "HOST", Config.BuildField.host_debug)
            buildConfigField("String", "API_BEARER_AUTH", Config.BuildField.api_bearer_debug)
            buildConfigField("String", "PROFILE", Config.BuildField.api_profile_debug)

        }
        getByName("release") {
            buildConfigField("String", "HOST", Config.BuildField.host_release)
            buildConfigField("String", "API_BEARER_AUTH", Config.BuildField.api_bearer_release)
            buildConfigField("String", "PROFILE", Config.BuildField.api_profile_release)
        }
    }
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlin.stdlib)
            implementation(libs.koin.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.serialization.json)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logger)
            implementation(libs.ktor.client.auth)
            implementation(compose.components.resources)
            implementation(compose.runtime)
        }

        androidMain.dependencies {
            implementation(libs.okhttp)
            implementation(libs.interceptor)
            implementation(libs.ktor.client.okhttp)
        }
    }
}