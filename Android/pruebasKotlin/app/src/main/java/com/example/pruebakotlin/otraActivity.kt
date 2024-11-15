package com.example.pruebakotlin

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class otraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otra)
        val lblResult: TextView = findViewById(R.id.textView2)
        val extras = intent.extras
        val userInfo: String? = extras?.getString("UserData")
        lblResult.setText(userInfo)
    }
}