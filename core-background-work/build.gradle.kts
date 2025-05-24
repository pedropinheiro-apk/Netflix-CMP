@file:Suppress("UnstableApiUsage")

plugins {
    id("com.streamplayer.kmp-library")
}

kotlin {
    sourceSets {
        sourceSets {
            commonMain.dependencies {
                implementation(projects.coreShared)
                implementation(projects.coreSharedUi)
            }
        }
    }
}