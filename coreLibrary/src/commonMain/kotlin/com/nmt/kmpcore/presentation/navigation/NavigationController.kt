package com.nmt.kmpcore.presentation.navigation

internal interface NavigationController {
    fun navigate(route: String, popUpTo: String? = null)
    fun navigateAndClearStack()
    fun popBackStack()
    fun getReadableRoute()
}