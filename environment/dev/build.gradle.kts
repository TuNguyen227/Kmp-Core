import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(coreLibs.plugins.kotlinMultiplatform)
    alias(coreLibs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.configureEach {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "environment"
            isStatic = true
        }
    }
    sourceSets {
        androidMain.dependencies {
        }
        commonMain.dependencies {
        }
        iosMain.dependencies {
        }
    }
}

android {
    namespace = "com.nmt.kmpcore"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
