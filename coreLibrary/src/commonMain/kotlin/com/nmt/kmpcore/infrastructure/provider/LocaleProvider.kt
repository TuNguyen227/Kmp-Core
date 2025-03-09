package com.nmt.kmpcore.infrastructure.provider

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object LocaleProvider {
    fun getRegion(): String
}