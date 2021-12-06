package com.bMao.appmintic_practicando.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bMao.appmintic_practicando.Main.MainActivity
import com.bMao.appmintic_practicando.R
import com.google.android.material.textfield.TextInputEditText


class RegistroSuperheroeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_superheroe)

        val infoTextView : TextView = findViewById(R.id.info_text_view)
        val registrarButton : Button = findViewById(R.id.registrar_button)
        //Info
        val nombreEditText : EditText = findViewById(R.id.nombre_edit_text)
        val estaturaEditText : TextInputEditText = findViewById(R.id.estatura_edit_text)
        val masculinoRadioButton : RadioButton = findViewById(R.id.masculino_radio_button)
        val femeninoRadioButton : RadioButton = findViewById(R.id.femenino_radio_button)
        val fuerzaCheckBox : CheckBox = findViewById(R.id.super_fueza_checkbox)
        val velocidadCheckBox : CheckBox = findViewById(R.id.velocidad_check_box)
        val telequinesisCheckBox : CheckBox = findViewById(R.id.telequinesis_checkbox)
        val ciudadSpinner: Spinner = findViewById(R.id.ciudad_spinner)

        registrarButton.setOnClickListener{
            if(estaturaEditText.text.toString() == ""){
                estaturaEditText.error = "Digite la estatura"
            }
            if(nombreEditText.text.isEmpty()){
                Toast.makeText(this,"Debe digitar un nombre y estatura",Toast.LENGTH_LONG).show()
            }else{
                val nombre = nombreEditText.text.toString()
                val estatura : Float = estaturaEditText.text.toString().toFloat()
                var poderes = ""
                val ciudad = ciudadSpinner.selectedItem.toString()
                val genero = if(masculinoRadioButton.isChecked) getString(R.string.masculino) else getString(
                    R.string.femenino
                )
                if (fuerzaCheckBox.isChecked) poderes = getString(R.string.super_fuerza)
                if (velocidadCheckBox.isChecked) poderes = poderes +" "+ getString(R.string.velocidad)
                if (telequinesisCheckBox.isChecked) poderes+= poderes +" "+ getString(R.string.telequinesis)

                infoTextView.text = getString(R.string.info, nombre, estatura, genero, poderes, ciudad)

                //val superheroe = Superheroe(nombre,estatura,poderes,ciudad,genero)

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("nombre",nombre)
                startActivity(intent)
            }
        }
    }
}