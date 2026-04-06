package com.example.projeto_frases.ui.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.projeto_frases.R
import com.example.projeto_frases.databinding.ActivityMainBinding
import com.example.projeto_frases.ui.helper.MotivationConstants
import com.example.projeto_frases.ui.repository.PhraseRepository
import com.example.projeto_frases.ui.repository.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: PhraseRepository
    private lateinit var securityPreferences: SecurityPreferences
    private var categorySelected = MotivationConstants.PHRASE.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        securityPreferences = SecurityPreferences(this)
        repository = PhraseRepository()

        val nome = securityPreferences.getString(
            MotivationConstants.KEY.PERSON_NAME
        )

        if (nome.isEmpty()) {
            startActivity(Intent(this, UserActivity::class.java))
            finish()
            return
        }

        binding.titulo.text = "Olá, $nome!"

        handleFilter(
            MotivationConstants.PHRASE.ALL,
            binding.imgInfinito,
            binding.imgEmoji,
            binding.imgDia
        )

        setListeners()
        refreshPhrase()
    }

    private fun setListeners() {
        binding.imgInfinito.setOnClickListener(this)
        binding.imgEmoji.setOnClickListener(this)
        binding.imgDia.setOnClickListener(this)
        binding.btnNovaFrase.setOnClickListener(this)
    }

    private fun refreshPhrase() {
        binding.textoFrase.text = repository.getPhrase(categorySelected)
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.img_infinito -> {
                handleFilter(
                    MotivationConstants.PHRASE.ALL,
                    binding.imgInfinito,
                    binding.imgEmoji,
                    binding.imgDia
                )
                refreshPhrase()
            }

            R.id.img_emoji -> {
                handleFilter(
                    MotivationConstants.PHRASE.HAPPY,
                    binding.imgInfinito,
                    binding.imgEmoji,
                    binding.imgDia
                )
                refreshPhrase()
            }

            R.id.img_dia -> {
                handleFilter(
                    MotivationConstants.PHRASE.SUNNY,
                    binding.imgInfinito,
                    binding.imgEmoji,
                    binding.imgDia
                )
                refreshPhrase()
            }

            R.id.btnNovaFrase -> {
                refreshPhrase()
            }
        }
    }

    private fun handleFilter(id: Int, vararg images: ImageView) {

        categorySelected = id

        for (img in images) {
            img.setColorFilter(ContextCompat.getColor(this, android.R.color.black))
        }

        when (id) {
            MotivationConstants.PHRASE.ALL -> {
                images[0].setColorFilter(ContextCompat.getColor(this, android.R.color.white))
            }
            MotivationConstants.PHRASE.HAPPY -> {
                images[1].setColorFilter(ContextCompat.getColor(this, android.R.color.white))
            }
            MotivationConstants.PHRASE.SUNNY -> {
                images[2].setColorFilter(ContextCompat.getColor(this, android.R.color.white))
            }
        }
    }
}