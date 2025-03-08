enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("coreLibs") {
            from(files("gradle/corelibs.versions.toml")) // Load submodule-specific versions
        }
    }
}

rootProject.name = "Kmp-Core"
include(":coreLibrary")
include(":environment:dev",":environment:release")