package com.nmt.kmpcore.network.builder

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.EndpointConfig
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
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

    override fun build(endPointConfig: EndpointConfig?,headers: Headers?,jsonConfiguration: JsonConfiguration?,auth: Auth?): HttpClient {
        return HttpClient(CIO) {
            engine {
                endPointConfig ?: this.endpoint
            }
            defaultRequest {
                url {
                   protocol = baseProtocol
                    host = baseURL
                }
                header(HttpHeaders.ContentType,"application/json")
                headers?.apply {}
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

            install(Auth) {
                auth?.apply {}
            }

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