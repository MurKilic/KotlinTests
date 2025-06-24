package com.example.loginapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Titel setzen
        binding.mainMenuTitle.text = "Hauptmenü"

        // Radiobutton: Sichtbar und bearbeitbar
        binding.radioAktiv.setOnClickListener {
            binding.editTextBlock.visibility = View.VISIBLE
            binding.editTextBlock.isEnabled = true
        }

        // Radiobutton: Unsichtbar
        binding.radioDeaktiv.setOnClickListener {
            binding.editTextBlock.visibility = View.GONE
        }

        // Radiobutton: Sichtbar, aber nicht bearbeitbar
        binding.radioNurLesen.setOnClickListener {
            binding.editTextBlock.visibility = View.VISIBLE
            binding.editTextBlock.isEnabled = false
        }
    }
}
