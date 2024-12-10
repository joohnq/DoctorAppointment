package com.joohnq.doctorappointment.validator

import com.joohnq.doctorappointment.exception.EmailException

object EmailValidator {
    operator fun invoke(email: String): Boolean {
        if (email.isEmpty()) throw EmailException.EmptyEmail
        if ("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex().matches(email)
                .not()
        ) throw EmailException.InvalidEmail
        return true
    }
}