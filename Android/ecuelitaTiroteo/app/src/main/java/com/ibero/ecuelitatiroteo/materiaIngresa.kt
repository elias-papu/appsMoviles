package com.ibero.ecuelitatiroteo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class materiaIngresa : AppCompatActivity() {
    private var dataManager: DataManager? = null
    private var listaMaterias: ListView? = null
    private var misMaterias: ArrayList<Materia>? = null
    private var miMateria: Materia? = null
    private var editClave: EditText? = null
    private var editNombreMateria: EditText? = null
    private var editCreditos: EditText? = null
    private var botonGuardar: Button? = null
    private var botonLimpiar: Button? = null
    private var botonEliminar: Button? = null
    private var botonActualizar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materia_ingresa)
        dataManager = DataManager(applicationContext)
        listaMaterias = findViewById(R.id.listaMaterias) as ListView
        editClave = findViewById(R.id.editClave) as EditText
        editNombreMateria = findViewById(R.id.editNombre) as EditText
        editCreditos = findViewById(R.id.editCreditos) as EditText
        botonGuardar = findViewById(R.id.botonGuardarMateria) as Button
        botonLimpiar = findViewById(R.id.botonLimpiarMateria) as Button
        botonEliminar = findViewById(R.id.botonEliminarMateria) as Button
        botonActualizar = findViewById(R.id.botonActualizarMateria) as Button

        botonGuardar!!.setOnClickListener {
            if (validaDatos()) {
                try {
                    miMateria = Materia()
                    val creditosText = editCreditos!!.text.toString()
                    miMateria!!.clave = editClave!!.text.toString()
                    miMateria!!.nombre = editNombreMateria!!.text.toString()
                    if (creditosText != "") {
                        miMateria!!.creditos = creditosText.toInt()
                    }
                    if (dataManager!!.guardarMateria(miMateria!!) != -1L) {
                        Toast.makeText(
                            applicationContext,
                            "Materia Guardada!!!",
                            Toast.LENGTH_SHORT
                        ).show()
                        mostrarMaterias()
                        limpiarDatos()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Error al guardar!!!\nPosiblemente ya existe",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (ex: Exception) {
                    Toast.makeText(applicationContext, ex.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        botonActualizar!!.setOnClickListener {
            if (miMateria != null) {
                if (miMateria!!.clave == editClave!!.text.toString()) {
                    miMateria!!.nombre = editNombreMateria!!.text.toString()
                    val creditosText = editCreditos!!.text.toString()
                    if (creditosText != "") {
                        miMateria!!.creditos = creditosText.toInt()
                    }
                    if (dataManager!!.actualizarMateria(miMateria!!) > 0) {
                        Toast.makeText(
                            applicationContext,
                            "Registro actualizado!!!",
                            Toast.LENGTH_SHORT
                        ).show()
                        mostrarMaterias()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Error para actualizar los datos!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "La clave no se puede cambiar!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "Debe elegir una materia existente de la lista",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        botonLimpiar!!.setOnClickListener { limpiarDatos() }

        botonEliminar!!.setOnClickListener {
            val clave = editClave!!.text.toString()
            if (clave.length == 5) {
                if (dataManager!!.eliminarMateria(clave) > 0) {
                    Toast.makeText(
                        applicationContext,
                        "Materia borrada exitosamente!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                    mostrarMaterias()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Error al borrar materia!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "Debe elegir una materia existente de la lista o ingresar la clave",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        listaMaterias!!.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                miMateria = listaMaterias!!.getItemAtPosition(position) as Materia
                editClave!!.setText(miMateria!!.clave)
                editNombreMateria!!.setText(miMateria!!.nombre)
                editCreditos!!.setText(miMateria!!.creditos.toString())
            }

        mostrarMaterias()
        limpiarDatos()
    }

    private fun validaDatos(): Boolean {
        if (editClave!!.text.toString().length != 5) {
            Toast.makeText(
                applicationContext,
                "Necesita poner la clave de 5 caracteres!",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        if (editNombreMateria!!.text.toString() == "") {
            Toast.makeText(
                applicationContext,
                "Nombre de la materia indispensable!",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }

    private fun limpiarDatos() {
        editClave!!.setText("")
        editNombreMateria!!.setText("")
        editCreditos!!.setText("")
        miMateria = null
    }

    private fun mostrarMaterias() {
        try {
            misMaterias = dataManager!!.leerMaterias()
            val adaptador = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_list_item_1,
                misMaterias!!
            )
            listaMaterias!!.adapter = adaptador
            listaMaterias!!.isVerticalScrollBarEnabled = true
        } catch (ex: Exception) {
            Toast.makeText(applicationContext, ex.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun onPause() {
        super.onPause()
        dataManager!!.cerrar()
    }

    override fun onResume() {
        super.onResume()
        dataManager!!.abrir()
    }
}