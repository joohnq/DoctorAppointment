package com.joohnq.doctorappointment

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.joohnq.doctorappointment.ui.Child
import com.joohnq.doctorappointment.ui.RootComponent
import com.joohnq.doctorappointment.ui.presentation.sign_in.SignIn
import com.joohnq.doctorappointment.ui.presentation.sign_up.SignUp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun DoctorAppointment(root: RootComponent) {
    MaterialTheme {
        val stack by root.stack.subscribeAsState()
        Children(stack = stack, animation = stackAnimation(fade())) { child ->
            when (val instance = child.instance) {
                is Child.SignIn -> SignIn(instance.component)
                is Child.SignUp -> SignUp(instance.component)
            }
        }
    }
}