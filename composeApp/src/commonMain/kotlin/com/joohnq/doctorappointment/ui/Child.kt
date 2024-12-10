package com.joohnq.doctorappointment.ui

import com.joohnq.doctorappointment.ui.presentation.sign_in.SignInComponent
import com.joohnq.doctorappointment.ui.presentation.sign_up.SignUpComponent

sealed class Child {
    data class SignUp(val component: SignUpComponent) : Child()
    data class SignIn(val component: SignInComponent) :
        Child()
}