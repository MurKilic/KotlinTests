package com.example.loginapp
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import com.example.tests.Smoke
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import kotlin.collections.forEach
import kotlin.jvm.java
import org.junit.Assert.assertTrue


@RunWith(AndroidJUnit4::class)
class PushNotificationTest :  Setup() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testPushAppearsInNotificationBar() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Push simulieren
        onView(withId(R.id.buttonPushTest)).perform(click())

        // Warten bis Notification erscheint
        //Thread.sleep(3000)

        // Notification Shade öffnen
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.openNotification()
        device.wait(Until.hasObject(By.text("Simulierter Push")), 3000)

        // Prüfen, ob Text sichtbar ist
        val notification = device.findObject(By.text("Simulierter Push"))
        assertTrue(notification != null)


    }

}
