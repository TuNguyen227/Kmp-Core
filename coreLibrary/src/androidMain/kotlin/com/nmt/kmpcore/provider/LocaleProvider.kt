package com.nmt.kmpcore.provider

import java.util.Locale

actual object LocaleProvider {
    actual fun getRegion(): String {
        return Locale.getDefault().country
    }
}