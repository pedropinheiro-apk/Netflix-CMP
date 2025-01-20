plugins {
    id("com.streamplayer.kmp-library")
}


kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.bundles.koin)
        }
    }
}