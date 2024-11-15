package com.example.personotasqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnIngresa: Button = findViewById(R.id.ingresa)
        val btnVer: Button = findViewById(R.id.ver)

        btnIngresa.setOnClickListener() {
            val ingresaPapu : Intent = Intent(applicationContext, ingresaPersona::class.java)
            startActivity(ingresaPapu)
        }

        btnVer.setOnClickListener() {
            val verPapu : Intent = Intent(applicationContext, vePersona::class.java)
            startActivity(verPapu)
        }
    }
}