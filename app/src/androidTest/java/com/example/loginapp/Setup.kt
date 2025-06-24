package com.example.loginapp

import android.util.Log
import org.junit.Before
import org.junit.After

open class Setup {

    private val TAG = "TestSetup"

    @Before
    fun setup() {
        Log.d(TAG, "🔧 Setup läuft")
        // Initialisierung, z. B. Mocks, Testdaten, etc.
    }

    @After
    fun teardown() {
        Log.d(TAG, "🧹 Teardown läuft")
        // Aufräumen, z. B. DB-Reset, Ressourcen schließen
    }
}