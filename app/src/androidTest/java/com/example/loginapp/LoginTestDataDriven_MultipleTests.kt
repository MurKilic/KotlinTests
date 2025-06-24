package com.example.loginapp
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.jvm.java

@RunWith(Parameterized::class)
class LoginTestDataDriven_MultipleTests(
    private val username: String,
    private val password: String,
    private val expectedMessage: String
) {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Benutzer: {0}, Passwort: {1}")
        fun data(): Collection<Array<String>> {
            return listOf(
                arrayOf("Koepek", "Koepek", "Login fehlgeschlagen"),
                arrayOf(" ", "Koepek", "Login fehlgeschlagen")
            )
        }
    }
    /** Data driven - every entry is 1 Test*/
    @Test
    fun testInvalidErrorMessage1() {
        // Starte MainActivity manuell für jeden Test
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.editUsername)).perform(typeText(username), closeSoftKeyboard())
        onView(withId(R.id.editPassword)).perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.buttonLogin)).perform(click())
        onView(withId(R.id.textResult)).check(matches(withText(expectedMessage)))
    }
}