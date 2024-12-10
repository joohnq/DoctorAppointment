package com.joohnq.doctorappointment.validator

import com.joohnq.doctorappointment.exception.StringException

object NameValidator {
    operator fun invoke(name: String): Boolean {
        if (name.isEmpty()) throw StringException.EmptyField("name")
        return true
    }
}