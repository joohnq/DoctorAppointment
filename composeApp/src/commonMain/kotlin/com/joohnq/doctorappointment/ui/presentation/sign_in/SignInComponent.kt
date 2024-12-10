package com.joohnq.doctorappointment.ui.presentation.sign_in

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.joohnq.doctorappointment.ui.Configuration
import com.joohnq.doctorappointment.exception.EmailException
import com.joohnq.doctorappointment.exception.PasswordException
import com.joohnq.doctorappointment.ui.presentation.sign_in.event.SignInEvent
import com.joohnq.doctorappointment.ui.presentation.sign_in.state.SignInState
import com.joohnq.doctorappointment.validator.EmailValidator
import com.joohnq.doctorappointment.validator.PasswordValidator

class SignInComponent(
    private val componentContext: ComponentContext,
    private val onNavigateToReplacing: (Configuration) -> Unit
) :
    ComponentContext by componentContext {

    private var _state = MutableValue(SignInState())
    val state: Value<SignInState> = _state

    fun onEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.OnEmailChanged -> _state.value =
                state.value.copy(email = event.email, emailError = null)

            is SignInEvent.OnEmailErrorChange -> _state.value =
                state.value.copy(emailError = event.error)

            is SignInEvent.OnPasswordChanged -> _state.value =
                state.value.copy(password = event.password, passwordError = null)

            is SignInEvent.OnPasswordErrorChange -> _state.value =
                state.value.copy(passwordError = event.error)

            SignInEvent.OnSignIn -> {
                try {
                    EmailValidator(state.value.email)
                    PasswordValidator(state.value.password)


                } catch (e: EmailException){
                    _state.value = state.value.copy(emailError = e.message)
                }catch (e: PasswordException){
                    _state.value = state.value.copy(passwordError = e.message)
                }
            }

            SignInEvent.OnNavigateToSignUp -> onNavigateToReplacing(Configuration.SignUp)
        }
    }
}