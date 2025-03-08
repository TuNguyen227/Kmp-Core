package com.nmt.kmpcore.data

interface TranslateRepository {
    suspend fun translate(strings: Array<String>, source: String, target: String) : String
}