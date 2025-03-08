import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    alias(coreLibs.plugins.kotlinMultiplatform)
    alias(coreLibs.plugins.composeMultiplatform)
    alias(coreLibs.plugins.androidLibrary)
    alias(coreLibs.plugins.compose.compiler)
    kotlin("plugin.serialization") version "2.1.10"
}

val environment : String by project

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
            baseName = "shared"
            isStatic = true
        }
    }
    sourceSets {
        androidMain.dependencies {
            implementation(coreLibs.ktor.client.android)
        }
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(project(":environment:$environment"))
            implementation(compose.runtime)
            // resources
            implementation(compose.components.resources)
            //ktor client
            implementation(coreLibs.bundles.ktor)
            implementation(coreLibs.ktor.client.auth)
            // koin
            implementation(project.dependencies.platform(coreLibs.koin.bom))
            implementation(coreLibs.koin.core)
        }
        iosMain.dependencies {
            implementation(coreLibs.ktor.client.darwin)
        }
        commonTest.dependencies {
            implementation(coreLibs.kotlin.test)
        }
    }

    targets.configureEach {
        compilations.configureEach {
            compilerOptions.configure {
                freeCompilerArgs.addAll("-Xexpect-actual-classes")
            }
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
