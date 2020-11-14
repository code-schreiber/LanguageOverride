package com.toolslab.languageoverride

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.toolslab.languageoverride.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(context: Context) {
        val newLanguage = LanguageProvider.currentLanguage.languageCode
        val newContext = LocaleChanger.changeLocale(context, newLanguage)
        super.attachBaseContext(newContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(ActivityMainBinding.inflate(layoutInflater)) {
            setContentView(root)
            title =
                resources.getString(R.string.app_name)
            resourcesLanguageTextView.text =
                resources.configuration.locale.language
            currentLanguageTextView.text =
                resources.getString(R.string.actual_language)
            actualLanguageTextView.text =
                LanguageProvider.currentLanguage.languageCode
            activityMainLanguageToggleButton.isChecked =
                LanguageProvider.currentLanguage == LanguageProvider.Language.Default

            activityMainLanguageToggleButton.setOnCheckedChangeListener { button, isChecked ->
                if (isChecked) {
                    LanguageProvider.set(LanguageProvider.Language.Default)
                } else {
                    LanguageProvider.set(LanguageProvider.Language.Other)
                }
                button.context.startActivity(Intent(button.context, MainActivity::class.java))
            }
        }
    }
}
