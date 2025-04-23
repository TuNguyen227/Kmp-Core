package com.nmt.kmpcore.presentation.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceAll

class RootComponent(
    componentContext: ComponentContext,
    initialConfiguration: Configuration,
    screenFactory: (Configuration,ComponentContext) -> AppChild
): ComponentContext by componentContext {

    private val navigator = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigator,
        serializer = Configuration.serializer(),
        initialConfiguration = initialConfiguration,
        handleBackButton = true,
        childFactory = screenFactory
    )

    fun navigate(configuration: Configuration, onComplete: (Boolean) -> Unit = {}) {
        navigator.pushNew(
            configuration = configuration,
            onComplete = onComplete
        )
    }

    fun navigateAndClearStack(configuration: Configuration,onComplete: (Boolean) -> Unit = {}) {
        navigator.replaceAll(
            configurations = arrayOf(configuration),
            onComplete = {
                onComplete(true)
            }
        )
    }

    fun popBackStack() {
        navigator.pop()
    }
}