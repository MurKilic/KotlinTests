package com.example.loginapp
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.uiautomator.UiDevice
import org.junit.runners.Parameterized
import kotlin.jvm.java

@RunWith(AndroidJUnit4::class)
class LoginTestTaner_SetAppHome{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testValidLoginShowsSuccessMessage() {
        onView(withId(R.id.editUsername)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.editPassword)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.buttonLogin)).perform(click())

        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
        Thread.sleep(5000)

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)
        //intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) // to clear entered values
        Thread.sleep(5000)
        context.startActivity(intent)
        Thread.sleep(5000)
    }


}
