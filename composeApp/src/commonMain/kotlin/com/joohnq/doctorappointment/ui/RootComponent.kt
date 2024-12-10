package com.joohnq.doctorappointment.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import com.joohnq.doctorappointment.ui.presentation.sign_in.SignInComponent
import com.joohnq.doctorappointment.ui.presentation.sign_up.SignUpComponent

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()

    val stack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.SignIn,
        childFactory = ::child,
        handleBackButton = true
    )

    fun onNavigateTo(configuration: Configuration) {
        navigation.replaceAll(configuration)
    }

    private fun child(
        configuration: Configuration,
        context: ComponentContext
    ): Child = when (configuration) {
        Configuration.SignIn -> Child.SignIn(
            component = SignInComponent(componentContext = context, onNavigateToReplacing = ::onNavigateTo),
        )

        Configuration.SignUp -> Child.SignUp(
            component = SignUpComponent(componentContext = context, onNavigateToReplacing = ::onNavigateTo),
        )
    }
}