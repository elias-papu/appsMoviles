package com.ibero.ecuelitatiroteo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE alumnos(" +
                    "matricula INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre VARCHAR(100) NOT NULL," +
                    "apellido_paterno VARCHAR(100) NOT NULL," +
                    "apellido_materno VARCHAR(100)," +
                    "fecha_nacimiento DATE," +
                    "sexo CHAR)"
        )

        db.execSQL(
            "CREATE TABLE materias(" +
                    "clave CHAR(5) PRIMARY KEY," +
                    "nombre VARCHAR(100)," +
                    "creditos INT DEFAULT 10)"
        )

        db.execSQL(
            "CREATE TABLE calificaciones(" +
                    "alumno INT," +
                    "materia CHAR(5)," +
                    "calificacion FLOAT," +
                    "fecha DATE," +
                    "PRIMARY KEY (alumno, materia)," +
                    "FOREIGN KEY (alumno) REFERENCES alumnos(matricula)," +
                    "FOREIGN KEY (materia) REFERENCES materias(clave))"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS calificaciones")
        db.execSQL("DROP TABLE IF EXISTS materias")
        db.execSQL("DROP TABLE IF EXISTS alumnos")
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "escuelita_ibero.db"
        private const val DB_VERSION = 1
    }
}