package com.joohnq.doctorappointment.ui.presentation.sign_up.screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.joohnq.doctorappointment.ui.components.PrimaryButton
import com.joohnq.doctorappointment.ui.components.TextFieldWithLabel
import com.joohnq.doctorappointment.ui.components.VerticalSpacer
import com.joohnq.doctorappointment.ui.presentation.sign_up.event.SignUpEvent
import com.joohnq.doctorappointment.ui.presentation.sign_up.state.SignUpState
import com.joohnq.doctorappointment.ui.theme.Colors
import com.joohnq.doctorappointment.ui.theme.TextStyles
import doctorappointment.composeapp.generated.resources.Res
import doctorappointment.composeapp.generated.resources.dont_have_an_account
import doctorappointment.composeapp.generated.resources.email_address
import doctorappointment.composeapp.generated.resources.enter_email_address
import doctorappointment.composeapp.generated.resources.enter_full_name
import doctorappointment.composeapp.generated.resources.enter_your_password
import doctorappointment.composeapp.generated.resources.full_name
import doctorappointment.composeapp.generated.resources.password
import doctorappointment.composeapp.generated.resources.sign_in
import doctorappointment.composeapp.generated.resources.sign_up
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignUpUIMain(
    state: SignUpState,
    onEvent: (SignUpEvent) -> Unit = {}
) {
    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Colors.BG1) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp).fillMaxSize(),
        ) {
            Text(
                text = stringResource(Res.string.sign_up),
                style = TextStyles.H2Bold(),
                color = Colors.Black
            )
            VerticalSpacer(70.dp)
            TextFieldWithLabel(
                text = Res.string.full_name,
                placeholder = Res.string.enter_full_name,
                value = state.name,
                onValueChange = { onEvent(SignUpEvent.OnNameChanged(it)) },
            )
            VerticalSpacer(30.dp)
            TextFieldWithLabel(
                text = Res.string.email_address,
                placeholder = Res.string.enter_email_address,
                value = state.email,
                onValueChange = { onEvent(SignUpEvent.OnEmailChanged(it)) },
            )
            VerticalSpacer(30.dp)
            TextFieldWithLabel(
                text = Res.string.password,
                placeholder = Res.string.enter_your_password,
                value = state.password,
                onValueChange = { onEvent(SignUpEvent.OnEmailChanged(it)) },
            )
            VerticalSpacer(30.dp)
            PrimaryButton(
                text = stringResource(Res.string.sign_in),
                onClick = { onEvent(SignUpEvent.OnSignUp) }
            )
            VerticalSpacer(20.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(Res.string.dont_have_an_account),
                    style = TextStyles.Body2Regular(),
                    color = Colors.Gray1
                )
                Text(
                    text = stringResource(Res.string.sign_in),
                    style = TextStyles.Body2Regular(),
                    color = Colors.Black,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = null,
                        onClick = { onEvent(SignUpEvent.OnNavigateToSignIn) }
                    )
                )
            }

        }
    }
}
