package com.joohnq.doctorappointment.ui.presentation.sign_up

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.joohnq.doctorappointment.ui.presentation.sign_up.screen.SignUpUIMain
import com.joohnq.doctorappointment.ui.presentation.sign_up.state.SignUpState

@Composable
fun SignUp(
    component: SignUpComponent
) {
    val state by component.state.subscribeAsState()

    SignUpUIMain(
        state = state,
        onEvent = component::onEvent
    )
}

@Preview
@Composable
fun SignUpUInPreview() {
    SignUpUIMain(
        state = SignUpState(),
    )
}