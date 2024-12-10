package com.joohnq.doctorappointment.entities

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val name: String,
    val email: String,
    val password: String
)