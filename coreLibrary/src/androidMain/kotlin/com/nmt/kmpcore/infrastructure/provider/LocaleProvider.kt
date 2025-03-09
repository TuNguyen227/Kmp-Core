package com.nmt.kmpcore.infrastructure.provider

import java.util.Locale

actual object LocaleProvider {
    actual fun getRegion(): String {
        return Locale.getDefault().country
    }
}