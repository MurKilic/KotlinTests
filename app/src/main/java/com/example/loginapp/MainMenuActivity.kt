package com.example.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainMenuTitle.text = "Hauptmenü"

    }
}
