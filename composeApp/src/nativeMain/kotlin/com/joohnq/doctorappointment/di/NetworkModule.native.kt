package com.joohnq.doctorappointment.di

import com.joohnq.doctorappointment.networking.HttpClientBuilder
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformNetworkModule: Module = module {
    singleOf<HttpClientEngine>(Darwin::create)
    single<HttpClient> { HttpClientBuilder.init(get()) }
}