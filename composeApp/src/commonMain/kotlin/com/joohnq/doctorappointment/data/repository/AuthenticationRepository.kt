package com.joohnq.doctorappointment.data.repository

import com.joohnq.doctorappointment.util.NetworkError
import com.joohnq.doctorappointment.util.Result
import com.joohnq.doctorappointment.entities.SignInRequest
import com.joohnq.doctorappointment.entities.SignUpRequest

interface AuthenticationRepository {
    suspend fun signIn(signInRequest: SignInRequest): Result<String, NetworkError>
    suspend fun signUp(signUpRequest: SignUpRequest): Result<Boolean, NetworkError>
}