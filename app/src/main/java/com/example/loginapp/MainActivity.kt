package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val user = binding.editUsername.text.toString()
            val pass = binding.editPassword.text.toString()

            if (user == "admin" && pass == "admin") {
                // 👉 Erfolgreicher Login → Starte MainMenuActivity
                val intent = Intent(this, MainMenuActivity::class.java)
                startActivity(intent)
            } else {
                binding.textResult.text = "Login fehlgeschlagen"
            }
        }
    }
}

