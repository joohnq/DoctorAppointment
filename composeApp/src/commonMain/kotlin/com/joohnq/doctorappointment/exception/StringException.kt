package com.joohnq.doctorappointment.exception

sealed class StringException(override val message: String): Exception(message) {
    data class EmptyField(val field: String): StringException("The $field cannot be empty")
}