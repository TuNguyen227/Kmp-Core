package com.nmt.kmpcore.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

object NavGraph {
    private var mNavController : NavController? = null
    @Composable
    fun render(navController: NavHostController, startDestination : Routes) {
        this.mNavController = navController
        NavHost(
            navController = navController,
            startDestination = ""
        )
    }
}