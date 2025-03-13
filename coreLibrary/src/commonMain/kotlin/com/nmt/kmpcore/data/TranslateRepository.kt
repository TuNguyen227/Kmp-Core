package com.nmt.kmpcore.data

internal interface TranslateRepository {
    suspend fun translate(strings: Array<String>, source: String, target: String) : String?
}