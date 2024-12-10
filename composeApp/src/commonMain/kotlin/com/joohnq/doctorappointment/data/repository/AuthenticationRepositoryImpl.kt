package com.joohnq.doctorappointment.data.repository

import com.joohnq.doctorappointment.util.NetworkError
import com.joohnq.doctorappointment.util.Result
import com.joohnq.doctorappointment.entities.SignInRequest
import com.joohnq.doctorappointment.entities.SignUpRequest
import com.joohnq.doctorappointment.networking.client.AuthenticationClient
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException

class AuthenticationRepositoryImpl(
    private val authenticationClient: AuthenticationClient
): AuthenticationRepository {
    override suspend fun signIn(signInRequest: SignInRequest): Result<String, NetworkError> =
        request<String> {
            authenticationClient.signIn(signInRequest)
        }

    override suspend fun signUp(signUpRequest: SignUpRequest): Result<Boolean, NetworkError> =
        request<Boolean> {
            authenticationClient.signUp(signUpRequest)
        }

    private suspend inline fun <reified T> request(block: () -> HttpResponse): Result<T, NetworkError> {
        val response = try {
            block()
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val body = response.body<T>()
                Result.Success(body)
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            409 -> Result.Error(NetworkError.CONFLICT)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}