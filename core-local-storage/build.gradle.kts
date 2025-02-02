plugins {
    id("com.streamplayer.kmp-library")
    id("com.google.devtools.ksp")
    alias(libs.plugins.room)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.room)
            implementation(libs.bundles.kotlin)
            implementation(libs.bundles.koin)
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
    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
    add("kspAndroid", libs.koin.ksp.compiler)
    add("kspIosSimulatorArm64", libs.koin.ksp.compiler)
    add("kspIosX64", libs.koin.ksp.compiler)
    add("kspIosArm64", libs.koin.ksp.compiler)
}

configurations.implementation{
    exclude(group = "com.intellij", module = "annotations")
}

room {
    schemaDirectory("$projectDir/schemas")
}
