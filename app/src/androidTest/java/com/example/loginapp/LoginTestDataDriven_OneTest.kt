package com.example.loginapp
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tests.Smoke
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import kotlin.collections.forEach
import kotlin.jvm.java

@RunWith(AndroidJUnit4::class)
class LoginTestDataDriven_OneTest :  Setup() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    /** Data driven - 1 Test runs multiple variations*/
    @Test
    @Category(Smoke::class)
    fun testInvalidLogins_DataDriven() {
        val testData = listOf(
            Triple("Koepek", "Koepek", "Login fehlgeschlagen"),
            Triple("", "", "Login fehlgeschlagen"),
            Triple("falsch", "1234", "Login fehlgeschlagen")

        )

        testData.forEach { (username, password, expectedMessage) ->
            // Vor jedem Durchlauf: zurück zur Start-Activity oder Felder leeren
            onView(withId(R.id.editUsername)).perform(clearText(), typeText(username), closeSoftKeyboard())
            onView(withId(R.id.editPassword)).perform(clearText(), typeText(password), closeSoftKeyboard())
            onView(withId(R.id.buttonLogin)).perform(click())
            onView(withId(R.id.textResult)).check(matches(withText(expectedMessage)))
        }
    }

}
