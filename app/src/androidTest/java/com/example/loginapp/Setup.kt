package com.example.loginapp

import android.util.Log
import android.widget.Toast
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.After

open class Setup {

    private val TAG = "TestSetup"

    @Before
    fun setup() {
        Log.d(TAG, "🔧 Setup läuft")



    }

    @After
    fun teardown() {
        Log.d(TAG, "🧹 Teardown läuft")
        // Aufräumen, z. B. DB-Reset, Ressourcen schließen
    }
}