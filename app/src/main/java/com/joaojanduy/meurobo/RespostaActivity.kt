package com.joaojanduy.meurobo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RespostaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)

        val respostaTextView = findViewById<TextView>(R.id.respostaTextView)
        val mensagem = intent.getStringExtra("mensagem") ?: ""

        val marciano = MarcianoPremium { "Ação personalizada" }
        val resposta = if (mensagem.startsWith("some") || mensagem.startsWith("subtraia") ||
            mensagem.startsWith("multiplique") || mensagem.startsWith("divida")) {
            val partes = mensagem.split(" ")
            if (partes.size >= 3) {
                val oper1 = partes[1].toDoubleOrNull()
                val oper2 = partes[2].toDoubleOrNull()
                marciano.responda(partes[0], oper1, oper2)
            } else {
                marciano.responda(mensagem)
            }
        } else {
            marciano.responda(mensagem)
        }

        respostaTextView.text = resposta
    }
}