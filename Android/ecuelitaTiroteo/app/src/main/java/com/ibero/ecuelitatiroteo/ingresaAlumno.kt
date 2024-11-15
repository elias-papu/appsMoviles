package com.ibero.ecuelitatiroteo

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class ingresaAlumno : AppCompatActivity() {

    private lateinit var etFechaNacimiento: EditText
    private lateinit var dataManager: DataManager
    private var secso: Char = 'I' // Inicializa con valor por defecto inválido

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresa_alumno)

        etFechaNacimiento = findViewById(R.id.etFechaNacimiento)
        val ingresa: Button = findViewById(R.id.btnGuardar)
        val nombre: EditText = findViewById(R.id.editNombre)
        val apPat: EditText = findViewById(R.id.editApPat)
        val apMat: EditText = findViewById(R.id.editTextApMat)
        val sexo: Spinner = findViewById(R.id.sexoSpinner)
        val btn: Button = findViewById(R.id.btnVer)

        // Inicializa dataManager aquí
        dataManager = DataManager(applicationContext)

        // Configuración del spinner
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.family, // Asegúrate que contiene las opciones correctas
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sexo.adapter = adapter

        // Manejo de selección del Spinner
        sexo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                secso = when (position) {
                    1 -> 'M' // Masculino
                    2 -> 'F' // Femenino
                    else -> 'I' // No seleccionado
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No acción necesaria
            }
        }

        // Listener para mostrar calendario
        etFechaNacimiento.setOnClickListener {
            mostrarCalendario()
        }

        // Botón para ir a la lista de alumnos
        btn.setOnClickListener {
            val intent = Intent(applicationContext, listaAlumnos::class.java)
            startActivity(intent)
        }

        // Listener para guardar el alumno
        ingresa.setOnClickListener {
            val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val name = nombre.text.toString()
            val pat = apPat.text.toString()
            val mat = apMat.text.toString()
            val fecha = etFechaNacimiento.text.toString()

            // Valida que la fecha no esté vacía
            if (fecha.isEmpty()) {
                Toast.makeText(this, "Debes ingresar la fecha de nacimiento", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Intenta parsear la fecha
            val fechaDate: Date? = try {
                formatoFecha.parse(fecha)
            } catch (e: Exception) {
                null
            }

            // Si la fecha es inválida, muestra mensaje y retorna
            if (fechaDate == null) {
                Toast.makeText(this, "Formato de fecha incorrecto", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Valida que todos los campos estén completos
            if (name.isNotEmpty() && pat.isNotEmpty() && mat.isNotEmpty() && secso != 'I') {
                val alumno = Alumno(name, pat, mat, fechaDate, secso)
                dataManager.guardarAlumno(alumno)
                Toast.makeText(this, "Alumno: $name guardado!", Toast.LENGTH_SHORT).show()

                // Limpia los campos
                nombre.setText("")
                apPat.setText("")
                apMat.setText("")
                etFechaNacimiento.setText("")
                sexo.setSelection(0) // Resetea el spinner a la posición inicial
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
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

        // Configurar límites de fecha
        val fechaMaxima = Calendar.getInstance()
        fechaMaxima.set(2005, Calendar.DECEMBER, 31)
        datePickerDialog.datePicker.maxDate = fechaMaxima.timeInMillis

        val fechaMinima = Calendar.getInstance()
        fechaMinima.add(Calendar.YEAR, -50)
        datePickerDialog.datePicker.minDate = fechaMinima.timeInMillis

        datePickerDialog.show()
    }

    override fun onPause() {
        super.onPause()
        dataManager.cerrar()
    }

    override fun onResume() {
        super.onResume()
        dataManager.abrir()
    }
}
