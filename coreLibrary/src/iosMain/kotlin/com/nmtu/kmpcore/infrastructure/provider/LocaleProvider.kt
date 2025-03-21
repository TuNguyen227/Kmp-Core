package com.nmtu.kmpcore.infrastructure.provider

import platform.Foundation.NSLocale
import platform.Foundation.NSLocaleCountryCode
import platform.Foundation.currentLocale

actual object LocaleProvider {
    actual fun getRegion(): String {
        val regionCode = NSLocale.currentLocale.objectForKey(NSLocaleCountryCode) as? String
        return regionCode ?: "us"
    }
}