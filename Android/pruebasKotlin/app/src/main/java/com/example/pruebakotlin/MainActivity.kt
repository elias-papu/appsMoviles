package com.example.pruebakotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLoad: Button = findViewById(R.id.button2)
        val tv: TextView = findViewById(R.id.tvLoadData)

        btnLoad.setOnClickListener {
            val eol = System.getProperty("line.separator")

            try {
                val input = BufferedReader(InputStreamReader(openFileInput("test_file")))
                val buffer = StringBuffer()
                var line: String?

                while (input.readLine().also { line = it } != null) {
                    buffer.append(line).append(eol)
                }

                tv.text = buffer.toString()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}