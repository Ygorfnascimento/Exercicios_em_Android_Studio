package com.example.projeto_combustivel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editGasolina: EditText
    lateinit var editAlcool: EditText
    lateinit var btnCalcular: Button
    lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editGasolina = findViewById(R.id.editGasolina)
        editAlcool = findViewById(R.id.editAlcool)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        btnCalcular.setOnClickListener {

            val gasolinaStr = editGasolina.text.toString()
            val alcoolStr = editAlcool.text.toString()

            if (gasolinaStr.isEmpty() || alcoolStr.isEmpty()) {
                txtResultado.text = "Preencha todos os campos!"
                return@setOnClickListener
            }

            val gasolina = gasolinaStr.toDouble()
            val alcool = alcoolStr.toDouble()

            val resultado = alcool / gasolina

            if (resultado < 0.7) {
                txtResultado.text = "Álcool é mais vantajoso"
            } else {
                txtResultado.text = "Gasolina é mais vantajosa"
            }
        }
    }
}