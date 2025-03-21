import com.codingfeline.buildkonfig.compiler.FieldSpec
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.Family

plugins {
    alias(coreLibs.plugins.kotlinMultiplatform)
    alias(coreLibs.plugins.composeMultiplatform)
    alias(coreLibs.plugins.androidLibrary)
    alias(coreLibs.plugins.compose.compiler)
    kotlin("plugin.serialization") version "2.1.10"
    id("com.codingfeline.buildkonfig") version "0.17.0"
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
    //applyDefaultHierarchyTemplate()
    iosX64()
    targets
        .filterIsInstance<KotlinNativeTarget>()
        .filter { it.konanTarget.family == Family.IOS }
        .forEach {
            it.binaries.framework {
                baseName = "shared"
                isStatic = true
                export(coreLibs.navigation.decompose)
                export(coreLibs.ktor.client.darwin)

//                // Optional, only if you need state preservation on Darwin (Apple) targets
//                export("com.arkivanov.essenty:state-keeper:<essenty_version>")
//
//                // Optional, only if you need state preservation on Darwin (Apple) targets
//                export("com.arkivanov.parcelize.darwin:runtime:<parcelize_darwin_version>")
            }
        }
    sourceSets {
        androidMain.dependencies {
            implementation(coreLibs.ktor.client.android)
        }
        commonMain.dependencies {
            //put your multiplatform dependencies her
            implementation(compose.runtime)
            // resources
            implementation(compose.components.resources)
            implementation(compose.ui)
            implementation(compose.material3)
            //ktor client
            implementation(coreLibs.bundles.ktor)
            // koin
            api(project.dependencies.platform(coreLibs.koin.bom))
            api(coreLibs.koin.core)
            // navigation
            api(coreLibs.navigation.decompose)
        }
        iosMain.dependencies {
            api(coreLibs.ktor.client.darwin)
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

compose.resources {
    publicResClass = true
    packageOfResClass = "com.nmt.kmpcore.coreLibrary.commonMain"
    generateResClass = always
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
buildkonfig {
    packageName = "com.nmt.kmpcore.coreLibrary"

    defaultConfigs {
        buildConfigConstField(FieldSpec.Type.BOOLEAN,"isDebug","true")
    }

    defaultConfigs("release") {
        buildConfigConstField(FieldSpec.Type.BOOLEAN,"isDebug","false")
    }
}
