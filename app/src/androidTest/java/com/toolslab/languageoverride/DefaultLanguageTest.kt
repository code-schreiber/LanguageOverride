package com.toolslab.languageoverride

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.toolslab.languageoverride.LanguageProvider.Language.Default
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DefaultLanguageTest {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun resources_language_is_default_language() {
        val textView = onView(withId(R.id.resourcesLanguageTextView))

        textView.check(matches(withText(Default.languageCode)))
    }

    @Test
    fun current_language_is_default_language() {
        val textView = onView(withId(R.id.currentLanguageTextView))

        textView.check(matches(withText(Default.languageCode)))
    }

    @Test
    fun actual_language_is_default_language() {
        val textView = onView(withId(R.id.actualLanguageTextView))

        textView.check(matches(withText(Default.languageCode)))
    }
}
