package com.example.personotasqlite

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class vePersona : AppCompatActivity() {

    private lateinit var dataManager: DataManager
    private lateinit var listaPersonitas: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ve_persona)

        dataManager = DataManager(applicationContext)
        listaPersonitas = findViewById(R.id.listaPersonitas)

        mostrarPersonitas()
    }

    private fun mostrarPersonitas() {
        try {
            val personitas: ArrayList<Personita> = dataManager.leerPersonitas()
            val adaptador: ArrayAdapter<Personita> = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                personitas
            )
            listaPersonitas.adapter = adaptador
            listaPersonitas.isVerticalScrollBarEnabled = true
        } catch (ex: Exception) {
            Toast.makeText(this, "Ocurrió un error al mostrar las personas." + ex, Toast.LENGTH_SHORT).show()
        }
    }
}
