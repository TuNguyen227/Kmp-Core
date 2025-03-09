package com.nmt.kmpcore.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Configuration {
    @Serializable
    data object HomeScreen : Configuration
}