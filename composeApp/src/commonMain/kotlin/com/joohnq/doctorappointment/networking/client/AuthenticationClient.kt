package com.joohnq.doctorappointment.networking.client

import com.joohnq.doctorappointment.entities.SignInRequest
import com.joohnq.doctorappointment.entities.SignUpRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthenticationClient(
    private val httpClient: HttpClient
) {
    suspend fun signIn(signInRequest: SignInRequest): HttpResponse =
        httpClient.post("http://0.0.0.0:8081/signup") {
            setBody(signInRequest)
            contentType(ContentType.Application.Json)
        }

    suspend fun signUp(signUpRequest: SignUpRequest): HttpResponse =
        httpClient.post("http://0.0.0.0:8081/signup") {
            setBody(signUpRequest)
        }
}