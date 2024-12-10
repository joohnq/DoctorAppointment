package com.joohnq.doctorappointment.exception

sealed class PasswordException(override val message: String) : Exception(message) {
    data object EmptyPassword : PasswordException(message = "The password cannot be empty")
    data object PasswordTooShort : PasswordException(message = "The password is too short, at least 8 characters")
}