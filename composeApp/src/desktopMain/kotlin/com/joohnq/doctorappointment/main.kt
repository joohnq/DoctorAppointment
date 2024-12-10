package com.joohnq.doctorappointment

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.joohnq.doctorappointment.ui.RootComponent

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Doctor Appointment",
    ) {
        val root = remember { RootComponent(DefaultComponentContext(LifecycleRegistry())) }
        DoctorAppointment(root)
    }
}