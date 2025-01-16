plugins {
    id("com.streamplayer.kmp-library")
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
        androidMain.dependencies {
            implementation(libs.bundles.kotlin)
            implementation(libs.bundles.networking)
            implementation(libs.bundles.koin)
        }
    }
}