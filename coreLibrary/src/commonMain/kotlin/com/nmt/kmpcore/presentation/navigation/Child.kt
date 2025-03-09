package com.nmt.kmpcore.presentation.navigation

sealed class Child {
    data class HomeScreen(val component: ScreenAComponent) : Child()
}
