package com.joohnq.doctorappointment.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class Configuration {
    @Serializable data object SignUp : Configuration()
    @Serializable data object SignIn : Configuration()
}