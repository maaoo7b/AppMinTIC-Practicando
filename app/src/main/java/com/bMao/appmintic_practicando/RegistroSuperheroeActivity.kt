package com.bMao.appmintic_practicando

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class RegistroSuperheroeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_superheroe)

        val registrarButton : Button = findViewById(R.id.registrar_button)
        var nombreEditText : EditText = findViewById(R.id.nombre_edit_text)
        var infoTextView : TextView = findViewById(R.id.info_text_view)

        registrarButton.setOnClickListener{
            val nombre = nombreEditText.text
            infoTextView.text = nombre

        }

    }
}