package com.nmt.kmpcore.network.builder

import com.nmt.kmpcore.coreLibrary.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMessageBuilder
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class BaseHttpClientBuilder : HttpClientBuilder {
    override lateinit var baseURL : String
    override var baseProtocol = URLProtocol.HTTPS

    fun protocol(protocol: URLProtocol) : BaseHttpClientBuilder {
        this.baseProtocol = protocol
        return this@BaseHttpClientBuilder
    }

    fun host(host: String) : BaseHttpClientBuilder {
        this.baseURL = host
        return this@BaseHttpClientBuilder
    }

    override fun build(headers: (HttpMessageBuilder.() -> Unit)?,jsonConfiguration: JsonConfiguration?): HttpClient {
        return HttpClient {
            expectSuccess = true
            defaultRequest {
                url {
                   protocol = baseProtocol
                    host = baseURL
                }
                header(HttpHeaders.ContentType,"application/json")
                headers?.invoke(this)
            }
            install(ContentNegotiation) {
                jsonConfiguration ?: json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
            if (BuildKonfig.isDebug) {
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            println(message)
                        }
                    }
                    level = LogLevel.ALL
                }
            }
        }
    }
}