package com.nmt.kmpcore.network.di

import com.nmt.kmpcore.network.TranslationApi
import com.nmt.kmpcore.network.TranslationDataSource
import com.nmt.kmpcore.network.builder.BaseHttpClientBuilder
import com.nmt.kmpcore.network.builder.HttpClientBuilder
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.headers
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.logging.Logger
import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun provideTranslationHttpClientModule(
    headers: Headers
) = module {
    single<HttpClient> {
        BaseHttpClientBuilder()
            .host("https://api.cognitive.microsofttranslator.com")
            .build(
                headers = headers
            )

    }

    single<TranslationApi> {
        TranslationDataSource(get())
    }
}