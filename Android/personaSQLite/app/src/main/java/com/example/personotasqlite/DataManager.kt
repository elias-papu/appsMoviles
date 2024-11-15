package com.example.personotasqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DataManager(private val contexto: Context) {
    private val dbHelper: DBHelper
    private var miBase: SQLiteDatabase

    init {
        dbHelper = DBHelper(contexto)
        miBase = dbHelper.writableDatabase
    }

    fun abrir() {
        miBase = dbHelper.writableDatabase
    }

    fun cerrar() {
        miBase.close()
    }

    fun guardarPersonita(fulanito: Personita) {
        val valores = ContentValues().apply {
            put("nombre", fulanito.nombre)
            put("apPat", fulanito.apPat)
            put("apMat", fulanito.apMat)
            put("fechaNac", fulanito.nacimiento)
            put("sexo", fulanito.sexo)
        }
        miBase.insert("personita", null, valores)
    }

    fun leerPersonitas(): ArrayList<Personita> {
        val personitas = ArrayList<Personita>()
        val columnas = arrayOf("nombre", "apPat", "apMat", "fechaNac", "sexo")

        val miCursor = miBase.query("personita", columnas, null, null, null, null, "nombre")
        while (miCursor.moveToNext()) {
            val nombre = miCursor.getString(miCursor.getColumnIndexOrThrow("nombre"))
            val apPat = miCursor.getString(miCursor.getColumnIndexOrThrow("apPat"))
            val apMat = miCursor.getString(miCursor.getColumnIndexOrThrow("apMat"))
            val fechaNac = miCursor.getString(miCursor.getColumnIndexOrThrow("fechaNac"))
            val sexo = miCursor.getString(miCursor.getColumnIndexOrThrow("sexo"))

            val fulanito = Personita(nombre, apPat, apMat, fechaNac, sexo)
            personitas.add(fulanito)
        }
        miCursor.close()
        return personitas
    }
}
