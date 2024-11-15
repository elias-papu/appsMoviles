package com.ibero.ecuelitatiroteo

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class menuAlumnos : AppCompatActivity() {
    private var dataManager: DataManager? = null
    private var miAlumno: Alumno? = null
    private var botonBuscar: Button? = null
    private var botonLimpiar: Button? = null
    private var editMatricula: EditText? = null
    private var textNombreCompleto: TextView? = null
    private var textSexo: TextView? = null
    private var textFechaNacimiento: TextView? = null
    private var textPromedio: TextView? = null
    private var listaCalificaciones: ListView? = null
    private var adaptadorCalificacion: ArrayAdapter<Calificacion>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_alumnos)
        dataManager = DataManager(applicationContext)
        miAlumno = null

        botonBuscar = findViewById(R.id.botonBuscarMatricula) as Button
        botonLimpiar = findViewById(R.id.botonLimpiarAlumno) as Button
        editMatricula = findViewById(R.id.editBuscarMatricula) as EditText
        textNombreCompleto = findViewById(R.id.textNombreCompleto) as TextView
        textSexo = findViewById(R.id.textSexoAlumno) as TextView
        textFechaNacimiento = findViewById(R.id.textFechaNacimientoAlumno) as TextView
        textPromedio = findViewById(R.id.textPromedio) as TextView
        listaCalificaciones = findViewById(R.id.listaCalificaciones) as ListView

        botonBuscar!!.setOnClickListener {
            var matricula = 0
            try {
                matricula = editMatricula!!.text.toString().toInt()
                miAlumno = dataManager!!.leerAlumno(matricula)
                if (miAlumno != null) {
                    miAlumno!!.calificaciones = dataManager!!.leerCalificaciones(matricula)
                    adaptadorCalificacion = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_list_item_1, miAlumno!!.calificaciones
                    )
                    listaCalificaciones!!.adapter = adaptadorCalificacion
                    listaCalificaciones!!.isVerticalScrollBarEnabled = true

                    textNombreCompleto!!.text = miAlumno!!.getNombreCompleto()
                    textFechaNacimiento!!.text = miAlumno!!.leerFechaFormato("dd/MM/yyyy")
                    textSexo!!.text = if (miAlumno!!.sexo.toString() == "M") "Masculino" else "Femenino"
                    textPromedio!!.text =
                        String.format("Promedio: %.2f", miAlumno!!.calcularPromedio())
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Alumno no está inscrito!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (ex: Exception) {
                Toast.makeText(
                    applicationContext,
                    "Debe introducir una matrícula válida",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        botonLimpiar!!.setOnClickListener { limpiarDatos() }
    }

    private fun limpiarDatos() {
        miAlumno = null
        editMatricula!!.setText("")
        textFechaNacimiento!!.text = ""
        textNombreCompleto!!.text = ""
        textSexo!!.text = ""
        textPromedio!!.text = "Promedio: 0.00"
        if (adaptadorCalificacion != null) {
            adaptadorCalificacion!!.clear()
            adaptadorCalificacion!!.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        dataManager!!.abrir()
    }

    override fun onPause() {
        super.onPause()
        dataManager!!.cerrar()
    }
}

