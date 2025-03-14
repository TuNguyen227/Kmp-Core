import com.codingfeline.buildkonfig.compiler.FieldSpec
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
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
    applyDefaultHierarchyTemplate()
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
            //put your multiplatform dependencies her
            implementation(compose.runtime)
            // resources
            implementation(compose.components.resources)
            //ktor client
            implementation(coreLibs.bundles.ktor)
            implementation(coreLibs.ktor.client.auth)
            // koin
            implementation(project.dependencies.platform(coreLibs.koin.bom))
            implementation(coreLibs.koin.core)
            // navigation
            implementation(coreLibs.navigation.decompose)
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
