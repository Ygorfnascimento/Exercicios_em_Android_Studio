package com.example.projetologin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        textView = findViewById(R.id.textView)
        getUserEmail()
    }

    private fun getUserEmail() {
        val email = AppContent.email
        textView.text = "Bem-vindo, $email!"
    }
}