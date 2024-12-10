package com.joohnq.doctorappointment.ui.presentation.sign_in.event

sealed class SignInEvent {
    data class OnEmailChanged(val email: String) : SignInEvent()
    data class OnEmailErrorChange(val error: String? = null) : SignInEvent()
    data class OnPasswordChanged(val password: String) : SignInEvent()
    data class OnPasswordErrorChange(val error: String? = null) : SignInEvent()
    data object OnSignIn : SignInEvent()
    data object OnNavigateToSignUp : SignInEvent()
}