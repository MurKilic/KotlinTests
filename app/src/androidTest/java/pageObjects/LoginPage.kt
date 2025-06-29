package com.example.loginapp.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.loginapp.R

class LoginPage {

    // Element-Definitionen (Selektoren zentral verwaltet)
    private val inputUsername: ViewInteraction get() = onView(withId(R.id.editUsername))
    private val inputPassword: ViewInteraction get() = onView(withId(R.id.editPassword))
    private val buttonLogin: ViewInteraction get() = onView(withId(R.id.buttonLogin))
    private val textResult: ViewInteraction get() = onView(withId(R.id.textResult))


    // Aktionen / Methoden
    fun enterUsername(username: String): LoginPage {
        inputUsername.perform(clearText(), typeText(username), closeSoftKeyboard())
        return this
    }

    fun enterPassword(password: String): LoginPage {
        inputPassword.perform(clearText(), typeText(password), closeSoftKeyboard())
        return this
    }

    fun clickLogin(): LoginPage {
        buttonLogin.perform(click())
        return this
    }

    fun verifyResult(expectedMessage: String): LoginPage {
        textResult.check(matches(withText(expectedMessage)))
        return this
    }

    fun loginWith(username: String, password: String): LoginPage {
        return enterUsername(username)
            .enterPassword(password)
            .clickLogin()
    }
}