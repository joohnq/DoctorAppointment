package com.joohnq.doctorappointment

import android.app.Application
import com.joohnq.doctorappointment.di.KoinInitializer

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(this).init()
    }
}