package com.ibero.ecuelitatiroteo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class listaAlumnos : AppCompatActivity() {
    var dataManager: DataManager? = null
    var listaAlumnos: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alumnos)

        dataManager = DataManager(applicationContext)
        listaAlumnos = findViewById(R.id.listaAlumnos)

        try {
            val misAlumnos = dataManager!!.leerAlumnos()
            val adapter = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_list_item_1,
                misAlumnos
            )

            listaAlumnos!!.adapter = adapter
        } catch (ex: Exception) {
            Toast.makeText(applicationContext, ex.message, Toast.LENGTH_LONG).show()
        }

        listaAlumnos!!.isVerticalScrollBarEnabled = true
    }

    override fun onPause() {
        super.onPause()
        // Implementación personalizada en caso necesario
    }

    override fun onResume() {
        super.onResume()
        // Implementación personalizada en caso necesario
    }
}