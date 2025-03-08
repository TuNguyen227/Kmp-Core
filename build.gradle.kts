plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(coreLibs.plugins.androidLibrary).apply(false)
    alias(coreLibs.plugins.kotlinMultiplatform).apply(false)
    alias(coreLibs.plugins.compose.compiler).apply(false)
}
