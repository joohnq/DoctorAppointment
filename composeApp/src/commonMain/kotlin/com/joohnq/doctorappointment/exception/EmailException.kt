package com.joohnq.doctorappointment.exception

sealed class EmailException(override val message: String) : Exception(message) {
    data object EmptyEmail : EmailException(message = "The email cannot be empty")
    data object InvalidEmail : EmailException(message = "The email is invalid")
}