plugins {
    id("com.streamplayer.kmp-library")
    alias(libs.plugins.room)
    if (System.getenv("DISABLE_KSP") != "true") {
        id("com.google.devtools.ksp")
    }
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.room.bundled)
            implementation(libs.room.runtime)
            implementation(libs.koin.core)
        }
    }
}

dependencies {
    add("kspAndroid", libs.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}
