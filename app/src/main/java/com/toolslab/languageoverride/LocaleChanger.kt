package com.toolslab.languageoverride

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

object LocaleChanger {
    fun changeLocale(oldContext: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration = Configuration(oldContext.resources.configuration).apply {
            setLayoutDirection(locale)
            setLocale(locale)
        }
        return oldContext.createConfigurationContext(configuration)
    }
}
