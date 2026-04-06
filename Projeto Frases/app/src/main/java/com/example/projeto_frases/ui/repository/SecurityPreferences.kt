package com.example.projeto_frases.ui.repository

import android.content.Context

class SecurityPreferences(context: Context) {

    private val preferences =
        context.getSharedPreferences("Motivacionais", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return preferences.getString(key, "") ?: ""
    }
}