package com.joohnq.doctorappointment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joohnq.doctorappointment.data.repository.AuthenticationRepository
import com.joohnq.doctorappointment.entities.SignInRequest
import com.joohnq.doctorappointment.entities.SignUpRequest
import com.joohnq.doctorappointment.util.onError
import com.joohnq.doctorappointment.util.onSuccess
import com.joohnq.doctorappointment.ui.state.UiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AuthenticationState(
    val signInStatus: UiState<String> = UiState.Idle,
    val signUpStatus: UiState<Boolean> = UiState.Idle
)

sealed class AuthenticationEvent {
    data class SignIn(val email: String, val password: String) : AuthenticationEvent()
    data class SignUp(val name: String, val email: String, val password: String) :
        AuthenticationEvent()
}

class AuthenticationViewModel(
    private val authenticationRepository: AuthenticationRepository,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state: MutableStateFlow<AuthenticationState> =
        MutableStateFlow(AuthenticationState())
    val state: StateFlow<AuthenticationState> get() = _state.asStateFlow()

    fun onEvent(event: AuthenticationEvent) {
        when (event) {
            is AuthenticationEvent.SignIn -> signIn(event.email, event.password)
            is AuthenticationEvent.SignUp -> signUp(
                event.name,
                event.email,
                event.password
            )
        }
    }

    private fun signIn(email: String, password: String) = viewModelScope.launch(dispatcher) {
        changeSignInState(UiState.Loading)
        val res = authenticationRepository.signIn(
            SignInRequest(
                email = email,
                password = password
            )
        )
        res.onSuccess {
            changeSignInState(UiState.Success(it))
        }.onError {
            changeSignInState(UiState.Error(it.name))
        }
    }

    private fun signUp(name: String, email: String, password: String) = viewModelScope.launch(dispatcher) {
        changeSignUpState(UiState.Loading)
        val res = authenticationRepository.signUp(
            SignUpRequest(
                name = name,
                email = email,
                password = password
            )
        )
        res.onSuccess {
            changeSignUpState(UiState.Success(it))
        }.onError {
            changeSignUpState(UiState.Error(it.name))
        }
    }

    private fun changeSignInState(signIn: UiState<String>) {
        _state.update { it.copy(signInStatus = signIn) }
    }

    private fun changeSignUpState(signUp: UiState<Boolean>) {
        _state.update { it.copy(signUpStatus = signUp) }
    }
}