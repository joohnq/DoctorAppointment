package com.joohnq.doctorappointment.ui.presentation.sign_in.state

data class SignInState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null
)