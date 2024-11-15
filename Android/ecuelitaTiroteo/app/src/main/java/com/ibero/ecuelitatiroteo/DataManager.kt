package com.ibero.ecuelitatiroteo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DataManager(context: Context) {
    private val dbHelper: SQLiteOpenHelper = DBHelper(context)
    private lateinit var miBase: SQLiteDatabase

    init {
        abrir()
    }

    fun abrir() {
        miBase = dbHelper.writableDatabase
    }

    fun cerrar() {
        if (miBase.isOpen) {
            miBase.close()
        }
    }

    fun borrarBase() {
        dbHelper.onUpgrade(miBase, 1, 1)
    }

    fun guardarAlumno(alumno: Alumno) {
        val valores = ContentValues().apply {
            put("nombre", alumno.nombre)
            put("apellido_paterno", alumno.apPat)
            put("apellido_materno", alumno.apMat)
            put("fecha_nacimiento", alumno.leerFechaFormato())
            put("sexo", alumno.sexo.toString())
        }
        miBase.insert("alumnos", null, valores)
    }

    fun leerAlumnos(): ArrayList<Alumno> {
        val alumnos = ArrayList<Alumno>()
        val columnas = arrayOf(
            "matricula", "nombre", "apellido_paterno",
            "apellido_materno", "fecha_nacimiento", "sexo"
        )

        val miCursor = miBase.query("alumnos", columnas, null, null, null, null, "matricula")
        miCursor.use { cursor ->
            while (cursor.moveToNext()) {
                alumnos.add(cursorToAlumno(cursor))
            }
        }
        return alumnos
    }

    fun leerAlumno(matricula: Int): Alumno? {
        val columnas = arrayOf(
            "matricula", "nombre", "apellido_paterno",
            "apellido_materno", "fecha_nacimiento", "sexo"
        )
        val args = arrayOf(matricula.toString())
        var miAlumno: Alumno? = null

        val miCursor = miBase.query("alumnos", columnas, "matricula=?", args, null, null, null)
        miCursor.use { cursor ->
            if (cursor.moveToFirst()) {
                miAlumno = cursorToAlumno(cursor)
            }
        }
        return miAlumno
    }

    private fun cursorToAlumno(cursor: Cursor): Alumno {
        return Alumno().apply {
            matricula = cursor.getInt(0)
            nombre = cursor.getString(1)
            apPat = cursor.getString(2)
            apMat = cursor.getString(3)
            setFechaNacimiento(cursor.getString(4))
            sexo = cursor.getString(5)[0]
        }
    }

    fun guardarMateria(materia: Materia): Long {
        val valores = ContentValues().apply {
            put("clave", materia.clave)
            put("nombre", materia.nombre)
            put("creditos", materia.creditos)
        }
        return miBase.insert("materias", null, valores)
    }

    fun actualizarMateria(materia: Materia): Int {
        val valores = ContentValues().apply {
            put("nombre", materia.nombre)
            put("creditos", materia.creditos)
        }
        val argumentos = arrayOf(materia.clave)
        return miBase.update("materias", valores, "clave=?", argumentos)
    }

    fun eliminarMateria(materia: Materia): Int {
        val argumentos = arrayOf(materia.clave)
        return miBase.delete("materias", "clave=?", argumentos)
    }

    fun eliminarMateria(clave: String): Int {
        val argumentos = arrayOf(clave)
        return miBase.delete("materias", "clave=?", argumentos)
    }

    fun leerMaterias(): ArrayList<Materia> {
        val materias = ArrayList<Materia>()
        val columnas = arrayOf("clave", "nombre", "creditos")

        val miCursor = miBase.query("materias", columnas, null, null, null, null, "clave")
        miCursor.use { cursor ->
            while (cursor.moveToNext()) {
                val materia = Materia().apply {
                    clave = cursor.getString(0)
                    nombre = cursor.getString(1)
                    creditos = cursor.getInt(2)
                }
                materias.add(materia)
            }
        }
        return materias
    }

    fun guardarCalificacion(matricula: Int, calificacion: Calificacion): Long {
        val valores = ContentValues().apply {
            put("alumno", matricula)
            put("materia", calificacion.materia?.clave)
            put("calificacion", calificacion.calificacion)
            put("fecha", calificacion.leerFechaFormato())
        }
        return miBase.insert("calificaciones", null, valores)
    }

    fun actualizarCalificacion(matricula: Int, calificacion: Calificacion): Int {
        val valores = ContentValues().apply {
            put("calificacion", calificacion.calificacion)
            put("fecha", calificacion.leerFechaFormato())
        }
        val argumentos = arrayOf(matricula.toString(), calificacion.materia?.clave)
        return miBase.update("calificaciones", valores, "alumno=? AND materia=?", argumentos)
    }

    fun leerCalificaciones(matricula: Int): ArrayList<Calificacion> {
        val calificaciones = ArrayList<Calificacion>()
        val argumentos = arrayOf(matricula.toString())
        val comando = "SELECT materia, calificacion, fecha, nombre, creditos " +
                "FROM calificaciones JOIN materias " +
                "ON materia=clave WHERE alumno=? ORDER BY materia"

        val miCursor = miBase.rawQuery(comando, argumentos)
        while (miCursor.moveToNext()) {
            val materia = Materia()
            val calificacion = Calificacion()
            calificacion.materia = materia

            materia.clave = miCursor.getString(0)
            calificacion.calificacion = miCursor.getDouble(1)
            calificacion.setFecha(miCursor.getString(2), calificacion.leerFechaFormato())
            materia.nombre = miCursor.getString(3)
            materia.creditos = miCursor.getInt(4)

            calificaciones.add(calificacion)
        }
        miCursor.close()
        return calificaciones
    }

    fun leerCalificacion(matricula: Int, claveMateria: String?): Calificacion? {
        var calificacion: Calificacion? = null
        val argumentos = arrayOf(claveMateria, matricula.toString())
        val comando = "SELECT materia, calificacion, fecha, nombre, creditos " +
                "FROM calificaciones JOIN materias " +
                "ON materia=? WHERE alumno=? ORDER BY materia"

        val miCursor = miBase.rawQuery(comando, argumentos)
        while (miCursor.moveToNext()) {
            val materia = Materia()
            calificacion = Calificacion()
            calificacion.materia = materia

            materia.clave = miCursor.getString(0)
            calificacion.calificacion = miCursor.getDouble(1)
            calificacion.setFecha(miCursor.getString(2), calificacion.leerFechaFormato())
            materia.nombre = miCursor.getString(3)
            materia.creditos = miCursor.getInt(4)
        }
        miCursor.close()
        return calificacion
    }

}