package com.joohnq.doctorappointment.ui.presentation.sign_up

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.joohnq.doctorappointment.ui.Configuration
import com.joohnq.doctorappointment.ui.presentation.sign_up.event.SignUpEvent
import com.joohnq.doctorappointment.ui.presentation.sign_up.state.SignUpState

class SignUpComponent(
    private val componentContext: ComponentContext,
    private val onNavigateToReplacing: (Configuration) -> Unit
) :
    ComponentContext by componentContext {

    private var _state = MutableValue(SignUpState())
    val state: Value<SignUpState> = _state

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.OnEmailChanged -> _state.value =
                state.value.copy(email = event.email, emailError = null)

            is SignUpEvent.OnEmailErrorChange -> _state.value =
                state.value.copy(emailError = event.error)

            is SignUpEvent.OnPasswordChanged -> _state.value =
                state.value.copy(password = event.password, passwordError = null)

            is SignUpEvent.OnPasswordErrorChange -> _state.value =
                state.value.copy(passwordError = event.error)

            is SignUpEvent.OnNameChanged -> _state.value =
                state.value.copy(nameError = event.name, passwordError = null)

            is SignUpEvent.OnNameErrorChange -> _state.value =
                state.value.copy(nameError = event.error)

            SignUpEvent.OnSignUp -> {}

            SignUpEvent.OnNavigateToSignIn -> onNavigateToReplacing(Configuration.SignIn)
        }
    }
}