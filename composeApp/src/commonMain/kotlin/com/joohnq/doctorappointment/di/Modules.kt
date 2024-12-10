package com.joohnq.doctorappointment.di

import com.joohnq.doctorappointment.data.repository.AuthenticationRepository
import com.joohnq.doctorappointment.data.repository.AuthenticationRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val viewModelModule = module {

}

val sharedModule = module {
    singleOf(Dispatchers::IO)
    singleOf(::AuthenticationRepositoryImpl) bind AuthenticationRepository::class
}
