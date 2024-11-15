package com.example.personotasqlite

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class ingresaPersona : AppCompatActivity() {
    private lateinit var etFechaNacimiento: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresa_persona)

        etFechaNacimiento = findViewById(R.id.etFechaNacimiento)

        val ingresa: Button = findViewById(R.id.ingresa)
        val nombre: EditText = findViewById(R.id.nombre)
        val apPat: EditText = findViewById(R.id.apPat)
        val apMat: EditText = findViewById(R.id.apMat)
        val masculino: RadioButton = findViewById(R.id.masculino)
        val femenino: RadioButton = findViewById(R.id.femenino)
        val dataManager = DataManager(applicationContext)

        etFechaNacimiento.setOnClickListener {
            mostrarCalendario()
        }

        ingresa.setOnClickListener() {
            val name: String = nombre.getText().toString()
            val pat: String = apPat.getText().toString()
            val mat: String = apMat.getText().toString()
            val fecha: String = etFechaNacimiento.getText().toString()
            var sexo: String? = null
            if(masculino.isChecked) {
                sexo = "masculino"
            }
            else if(femenino.isChecked) {
                sexo = "femenino"
            }
            else {
                Toast.makeText(
                    this@ingresaPersona,
                    "Sexo no ponido chabalete",
                    Toast.LENGTH_SHORT
                ).show()
            }
            if (!name.isEmpty() && !pat.isEmpty() && !mat.isEmpty() && !fecha.isEmpty()) {
                val fulanito = Personita(name, pat, mat, fecha, sexo)
                dataManager.guardarPersonita(fulanito)
                Toast.makeText(
                    this@ingresaPersona,
                    "Personita: $name guardada!",
                    Toast.LENGTH_SHORT
                ).show()
                nombre.setText("")
                apPat.setText("")
                apMat.setText("")
                etFechaNacimiento.setText("")
                if(masculino.isChecked) {
                    masculino.isChecked = false
                }
                else {
                    femenino.isChecked = false
                }
            } else {
                Toast.makeText(
                    this@ingresaPersona,
                    "Debés poner nombre boludo!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun mostrarCalendario() {
        val calendario = Calendar.getInstance()
        val anio = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, anioSeleccionado, mesSeleccionado, diaSeleccionado ->
                val mesAjustado = mesSeleccionado + 1
                val fecha = "%02d/%02d/%04d".format(diaSeleccionado, mesAjustado, anioSeleccionado)
                etFechaNacimiento.setText(fecha)
            },
            anio, mes, dia
        )
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()

        val fechaMinima = Calendar.getInstance()
        fechaMinima.add(Calendar.YEAR, -100)
        datePickerDialog.datePicker.minDate = fechaMinima.timeInMillis

        datePickerDialog.show()
    }
}