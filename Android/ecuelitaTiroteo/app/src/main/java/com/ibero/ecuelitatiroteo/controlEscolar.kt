package com.ibero.ecuelitatiroteo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class controlEscolar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_escolar)
        val btnAlu: Button = findViewById(R.id.btnAlumnos)
        val btnMat: Button = findViewById(R.id.btnMaterias)
        val imgUno: ImageView = findViewById(R.id.imageView2)
        val imgDos: ImageView = findViewById(R.id.imageView3)

        btnAlu.setOnClickListener() {
            val ingresaPapu : Intent = Intent(applicationContext, ingresaAlumno::class.java)
            startActivity(ingresaPapu)
        }
        imgUno.setOnClickListener() {
            val ingresaPapu : Intent = Intent(applicationContext, ingresaAlumno::class.java)
            startActivity(ingresaPapu)
        }
        btnMat.setOnClickListener() {
            val ingresaPapu : Intent = Intent(applicationContext, materiaIngresa::class.java)
            startActivity(ingresaPapu)
        }
        imgDos.setOnClickListener() {
            val ingresaPapu : Intent = Intent(applicationContext, materiaIngresa::class.java)
            startActivity(ingresaPapu)
        }
    }
}