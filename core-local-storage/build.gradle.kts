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

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "composeApp"
            isStatic = true
        }
    }
}

dependencies {
    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosX64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
}

configurations.implementation{
    exclude(group = "com.intellij", module = "annotations")
}

room {
    schemaDirectory("$projectDir/schemas")
}
