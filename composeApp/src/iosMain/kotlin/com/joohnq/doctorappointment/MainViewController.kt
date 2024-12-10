package com.joohnq.doctorappointment

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.joohnq.doctorappointment.di.KoinInitializer
import com.joohnq.doctorappointment.ui.RootComponent

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) {
    val root = remember { RootComponent(DefaultComponentContext(LifecycleRegistry())) }
    DoctorAppointment(root)
}