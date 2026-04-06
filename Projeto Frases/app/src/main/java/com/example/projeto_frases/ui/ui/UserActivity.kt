package com.example.projeto_frases.ui.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto_frases.databinding.ActivityUserBinding
import com.example.projeto_frases.ui.helper.MotivationConstants
import com.example.projeto_frases.ui.repository.SecurityPreferences

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        securityPreferences = SecurityPreferences(this)

        binding.buttonSave.setOnClickListener {
            handleSalvar()
        }
    }

    private fun handleSalvar() {
        val nome = binding.editName.text.toString().trim()

        if (nome.isEmpty()) {
            Toast.makeText(this, "Informe seu nome", Toast.LENGTH_SHORT).show()
        } else {

            securityPreferences.storeString(
                MotivationConstants.KEY.PERSON_NAME,
                nome
            )

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}