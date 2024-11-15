package com.example.holakotlinapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNombre : EditText = findViewById(R.id.editarN)
        val botonAceptar : Button = findViewById(R.id.button)
        val textSaludo : TextView = findViewById(R.id.textSaludo)
        val botonCambiar : Button = findViewById(R.id.buttonCambia)

        textSaludo.setText("")

        botonAceptar.setOnClickListener(View.OnClickListener {
            var nombre:String = editNombre.text.toString()
            textSaludo.setText("Hola $nombre, mucho gusto!")

            Toast.makeText(applicationContext, "Im steeeeve", Toast.LENGTH_SHORT).show()
        })

        botonCambiar.setOnClickListener(){
            val otraPantalla : Intent = Intent(applicationContext, LaOtraActivity::class.java)
            startActivity(otraPantalla)
        }
    }
}