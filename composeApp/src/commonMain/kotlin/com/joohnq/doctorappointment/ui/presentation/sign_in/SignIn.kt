package com.joohnq.doctorappointment.ui.presentation.sign_in

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.joohnq.doctorappointment.ui.presentation.sign_in.event.SignInEvent
import com.joohnq.doctorappointment.ui.presentation.sign_in.screen.SignInUI
import com.joohnq.doctorappointment.ui.presentation.sign_in.state.SignInState

@Composable
fun SignIn(
    component: SignInComponent
) {
    val state by component.state.subscribeAsState()

    LaunchedEffect(Unit){
        component.onEvent(SignInEvent.OnEmailChanged("joao@123.com"))
        component.onEvent(SignInEvent.OnPasswordChanged("joao12345"))
    }

    SignInUI(
        state = state,
        onEvent = component::onEvent
    )
}

@Preview
@Composable
fun SignInUInPreview() {
    SignInUI(
        state = SignInState(),
    )
}