package com.nmt.kmpcore.network.model.response

import kotlinx.serialization.Serializable

internal sealed interface TranslateResponse {
    @Serializable
    data class TranslateSuccess(
        val detectedLanguage: DetectedLanguage,
        val translations: List<Translation>
    ) : TranslateResponse

    @Serializable
    data class TranslateInvalid(
        val error: String
    ) : TranslateResponse

    @Serializable
    data class TranslateBanned(
        val error: String
    ) : TranslateResponse

    @Serializable
    data class TranslateSlowDown(
        val error: String
    ) : TranslateResponse

    @Serializable
    data class TranslateError(
        val error: String
    ) : TranslateResponse
}

@Serializable
data class DetectedLanguage(
    val language: String,
    val score: Double
)

@Serializable
data class Translation(
    val text: String,
    val to: String
)
