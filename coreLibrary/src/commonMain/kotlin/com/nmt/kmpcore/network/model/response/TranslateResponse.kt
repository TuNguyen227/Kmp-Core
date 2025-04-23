package com.nmt.kmpcore.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal sealed interface TranslateResponse {
    @Serializable
    @SerialName("translations")
    data class TranslateSuccess(
        @SerialName("text")
        val translatedText: String
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
