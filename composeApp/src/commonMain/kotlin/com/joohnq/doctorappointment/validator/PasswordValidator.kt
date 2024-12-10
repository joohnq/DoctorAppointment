package com.joohnq.doctorappointment.validator

import com.joohnq.doctorappointment.exception.PasswordException

object PasswordValidator {
    operator fun invoke(password: String): Boolean {
        if (password.isEmpty()) throw PasswordException.EmptyPassword
        if (password.length < 8) throw PasswordException.PasswordTooShort
        return true
    }
}