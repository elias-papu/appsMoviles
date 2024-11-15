package com.ibero.ecuelitatiroteo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class menuMaestros : AppCompatActivity() {

    private lateinit var spinAlumno: Spinner
    private lateinit var spinMateria: Spinner
    private lateinit var editCalificacion: EditText
    private lateinit var botonCalificar: Button
    private lateinit var dataManager: DataManager
    private var alumnos: ArrayList<Alumno>? = null
    private var materias: ArrayList<Materia>? = null
    private var miAlumno: Alumno? = null
    private var miMateria: Materia? = null
    private var miCalificacion: Calificacion? = null
    private var calificacion: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_maestros)

        // Inicializa los componentes de la vista
        dataManager = DataManager(applicationContext)
        spinAlumno = findViewById(R.id.spinnerAlumno)
        spinMateria = findViewById(R.id.spinnerMateria)
        editCalificacion = findViewById(R.id.editCalificacion)
        botonCalificar = findViewById(R.id.botonCalificar)

        cargarDatos()

        botonCalificar.setOnClickListener {
            asignarSeleccion()
            if (validaCalificacion()) {
                gestionarCalificacion()
                limpiarCampos()
            }
        }
    }

    private fun cargarDatos() {
        try {
            alumnos = dataManager.leerAlumnos()
            val adaptadorAlumno = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_spinner_dropdown_item,
                alumnos!!
            )
            spinAlumno.adapter = adaptadorAlumno

            materias = dataManager.leerMaterias()
            val adaptadorMateria = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_spinner_dropdown_item,
                materias!!
            )
            spinMateria.adapter = adaptadorMateria
        } catch (ex: Exception) {
            mostrarMensaje("Error al cargar los datos: ${ex.message}")
        }
    }

    private fun asignarSeleccion() {
        try {
            miMateria = spinMateria.selectedItem as Materia
            miAlumno = spinAlumno.selectedItem as Alumno
        } catch (ex: Exception) {
            mostrarMensaje("Error al cargar los datos seleccionados: ${ex.message}")
        }
    }

    private fun gestionarCalificacion() {
        miCalificacion = dataManager.leerCalificacion(miAlumno!!.matricula, miMateria!!.clave)
        if (miCalificacion == null) {
            miCalificacion = Calificacion(miMateria, calificacion!!)
            dataManager.guardarCalificacion(miAlumno!!.matricula, miCalificacion!!)
            mostrarMensaje("Calificación Guardada!!!")
        } else {
            miCalificacion!!.calificacion = calificacion!!
            miCalificacion!!.fecha = Date()
            dataManager.actualizarCalificacion(miAlumno!!.matricula, miCalificacion!!)
            mostrarMensaje("Calificación Actualizada!!!")
        }
    }

    private fun validaCalificacion(): Boolean {
        if (miAlumno == null || miMateria == null) {
            mostrarMensaje("Debe seleccionar el alumno y la materia")
            return false
        }
        return try {
            calificacion = editCalificacion.text.toString().toDouble()
            if (calificacion!! < 0 || calificacion!! > 10) {
                mostrarMensaje("La calificación debe ser entre 0 y 10!!!")
                false
            } else {
                true
            }
        } catch (ex: Exception) {
            mostrarMensaje("Debe ingresar una calificación válida")
            false
        }
    }

    private fun limpiarCampos() {
        calificacion = 0.0
        editCalificacion.setText("")
    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
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
