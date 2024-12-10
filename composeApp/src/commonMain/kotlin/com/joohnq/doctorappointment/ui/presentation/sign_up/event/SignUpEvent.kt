package com.joohnq.doctorappointment.ui.presentation.sign_up.event

sealed class SignUpEvent {
    data class OnNameChanged(val name: String) : SignUpEvent()
    data class OnNameErrorChange(val error: String? = null) : SignUpEvent()
    data class OnEmailChanged(val email: String) : SignUpEvent()
    data class OnEmailErrorChange(val error: String? = null) : SignUpEvent()
    data class OnPasswordChanged(val password: String) : SignUpEvent()
    data class OnPasswordErrorChange(val error: String? = null) : SignUpEvent()
    data object OnSignUp : SignUpEvent()
    data object OnNavigateToSignIn : SignUpEvent()
}