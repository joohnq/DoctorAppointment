package com.joohnq.doctorappointment.ui.presentation.sign_in.screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.joohnq.doctorappointment.ui.components.PrimaryButton
import com.joohnq.doctorappointment.ui.components.TextFieldWithLabel
import com.joohnq.doctorappointment.ui.components.VerticalSpacer
import com.joohnq.doctorappointment.ui.presentation.sign_in.event.SignInEvent
import com.joohnq.doctorappointment.ui.presentation.sign_in.state.SignInState
import com.joohnq.doctorappointment.ui.theme.Colors
import com.joohnq.doctorappointment.ui.theme.TextStyles
import doctorappointment.composeapp.generated.resources.Res
import doctorappointment.composeapp.generated.resources.email_address
import doctorappointment.composeapp.generated.resources.enter_email_address
import doctorappointment.composeapp.generated.resources.enter_your_password
import doctorappointment.composeapp.generated.resources.intro_doctors
import doctorappointment.composeapp.generated.resources.password
import doctorappointment.composeapp.generated.resources.sign_in
import doctorappointment.composeapp.generated.resources.sign_in_admin
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignInUI(
    state: SignInState,
    onEvent: (SignInEvent) -> Unit = {}
) {
    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Colors.BG1) {
        BoxWithConstraints {
            val constraints = this
            Row {
                if (constraints.maxWidth > 768.dp)
                    Box(
                        modifier = Modifier.fillMaxHeight().background(color = Colors.Gray5)
                            .weight(1f)
                            .paint(
                                painter = painterResource(Res.drawable.intro_doctors),
                                contentScale = ContentScale.Fit,
                                alignment = Alignment.BottomCenter,
                            )
                    )
                Box(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.widthIn(max = 700.dp).padding(24.dp).fillMaxSize(),
                    ) {
                        Text(
                            text = stringResource(Res.string.sign_in_admin),
                            style = TextStyles.H2Bold(),
                            color = Colors.Black
                        )
                        VerticalSpacer(70.dp)
                        TextFieldWithLabel(
                            text = Res.string.email_address,
                            placeholder = Res.string.enter_email_address,
                            value = state.email,
                            error = state.emailError,
                            onValueChange = { onEvent(SignInEvent.OnEmailChanged(it)) },
                        )
                        VerticalSpacer(30.dp)
                        TextFieldWithLabel(
                            text = Res.string.password,
                            placeholder = Res.string.enter_your_password,
                            value = state.password,
                            error = state.passwordError,
                            onValueChange = { onEvent(SignInEvent.OnPasswordChanged(it)) },
                        )
                        VerticalSpacer(30.dp)
                        PrimaryButton(
                            text = stringResource(Res.string.sign_in),
                            onClick = { onEvent(SignInEvent.OnSignIn) }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SignInUIAdminPreview() {
    SignInUI(
        state = SignInState(),
    )
}
