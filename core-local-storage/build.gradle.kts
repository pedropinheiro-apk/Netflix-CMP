plugins {
    id("com.streamplayer.kmp-library")
    id("com.google.devtools.ksp")
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.bundles.room)
            implementation(libs.bundles.kotlin)
            implementation(libs.bundles.koin)
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

dependencies {
    ksp(libs.roomCompiler)
}