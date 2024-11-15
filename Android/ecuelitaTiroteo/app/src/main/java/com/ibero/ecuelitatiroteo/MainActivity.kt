package com.ibero.ecuelitatiroteo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEsc: Button = findViewById(R.id.ctrlEsc)
        val btnMaeto: Button = findViewById(R.id.menuProf)
        val btnAlu: Button = findViewById(R.id.menuAlu)

        btnEsc.setOnClickListener() {
            val ingresaPapu : Intent = Intent(applicationContext, controlEscolar::class.java)
            startActivity(ingresaPapu)
        }
        btnMaeto.setOnClickListener() {
            val ingresaPapu : Intent = Intent(applicationContext, menuMaestros::class.java)
            startActivity(ingresaPapu)
        }
        btnAlu.setOnClickListener() {
            val ingresaPapu : Intent = Intent(applicationContext, menuAlumnos::class.java)
            startActivity(ingresaPapu)
        }
    }
}