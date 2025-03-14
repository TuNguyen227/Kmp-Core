package com.nmt.kmpcore.presentation.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew

class RootComponent(
    componentContext: ComponentContext,
    initialConfiguration: Configuration,
    screenFactory: (Configuration,ComponentContext) -> AppChild
): ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = initialConfiguration,
        handleBackButton = true,
        childFactory = screenFactory
    )

    fun navigate(configuration: Configuration, onComplete: (Boolean) -> Unit = {}) {
        navigation.pushNew(
            configuration = configuration,
            onComplete = onComplete
        )
    }
}