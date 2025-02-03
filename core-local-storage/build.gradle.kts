plugins {
    id("com.streamplayer.kmp-library")
    id("com.google.devtools.ksp")
    alias(libs.plugins.room)
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

configurations.implementation{
    exclude(group = "com.intellij", module = "annotations")
}

room {
    schemaDirectory("$projectDir/schemas")
}
