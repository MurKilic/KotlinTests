package com.example.loginapp

import android.Manifest
import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityMainBinding
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import android.content.pm.PackageManager

import android.widget.Toast
import androidx.annotation.RequiresPermission

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val notificationChannelId = "push_test_channel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Login-Button
        binding.buttonLogin.setOnClickListener {
            val user = binding.editUsername.text.toString()
            val pass = binding.editPassword.text.toString()

            if (user == "admin" && pass == "admin") {
                val intent = Intent(this, MainMenuActivity::class.java)
                startActivity(intent)
            } else {
                binding.textResult.text = "Login fehlgeschlagen"
            }
        }

        // Push-Test-Button
        binding.buttonPushTest.setOnClickListener {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
                checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED
            ) {
                binding.root.postDelayed({
                    sendTestNotification()
                }, 2000) // 2 Sekunden
            } else {
                requestPermissions(
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    101
                )
            }
        }
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    private fun sendTestNotification() {
        // Channel erstellen (nur einmal notwendig)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                notificationChannelId,
                "Push Test Kanal",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, notificationChannelId)
            .setSmallIcon(R.drawable.ic_dialog_info)
            .setContentTitle("Simulierter Push")
            .setContentText("Push it to the limit. \uD83C\uDFC3\u200D➡\uFE0F \uD83E\uDD3A \uD83C\uDFCB\uFE0F\u200D♂\uFE0F")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        NotificationManagerCompat.from(this).notify(1001, notification)
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101 &&
            grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            binding.root.postDelayed({
            sendTestNotification()
            }, 2000) // 2 Sekunden
        } else {
            Toast.makeText(this, "Benachrichtigung nicht erlaubt", Toast.LENGTH_SHORT).show()
        }
    }
}
