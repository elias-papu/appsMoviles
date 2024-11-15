package com.ibero.ecuelitatiroteo

import java.text.SimpleDateFormat
import java.util.Date

class Alumno {
    var matricula: Int = 0
    var nombre: String? = null
    var apPat: String? = null
    var apMat: String? = null
    var nacimiento: Date? = null
    var sexo: Char? = null
    var calificaciones: MutableList<Calificacion> = mutableListOf()

    constructor()

    constructor(nombre: String?, apPat: String?, apMat: String?) {
        this.nombre = nombre
        this.apPat = apPat
        this.apMat = apMat
    }

    constructor(nombre: String?, apPat: String?, apMat: String?, nacimiento: Date?, sexo: Char?) {
        this.nombre = nombre
        this.apPat = apPat
        this.apMat = apMat
        this.nacimiento = nacimiento
        this.sexo = sexo
    }

    constructor(
        matricula: Int,
        nombre: String?,
        apPat: String?,
        apMat: String?,
        nacimiento: Date?,
        sexo: Char?
    ) {
        this.matricula = matricula
        this.nombre = nombre
        this.apPat = apPat
        this.apMat = apMat
        this.nacimiento = nacimiento
        this.sexo = sexo
    }

    fun setFechaNacimiento(fecha: String) {
        val formato = SimpleDateFormat("yyyy-MM-dd")
        try {
            this.nacimiento = formato.parse(fecha) ?: Date()
        } catch (ex: Exception) {
            nacimiento = Date()
        }
    }

    fun setFechaNacimiento(fecha: String, formatoFecha: String) {
        val formato = SimpleDateFormat(formatoFecha)
        try {
            this.nacimiento = formato.parse(fecha) ?: Date()
        } catch (ex: Exception) {
            nacimiento = Date()
        }
    }

    fun leerFechaFormato(): String {
        val formato = SimpleDateFormat("yyyy-MM-dd")
        return formato.format(nacimiento)
    }

    fun leerFechaFormato(formatoFecha: String): String {
        val formato = SimpleDateFormat(formatoFecha)
        return formato.format(nacimiento)
    }

    // Método para calcular el promedio de calificaciones
    fun calcularPromedio(): Double {
        var promedio = 0.0
        var suma = 0.0
        val n = calificaciones.size

        if (n > 0) {
            for (calificacion in calificaciones) {
                suma += calificacion.calificacion
            }
            promedio = suma / n
        }

        return promedio
    }

    // Método para obtener el nombre completo del alumno
    fun getNombreCompleto(): String {
        return "$nombre $apPat $apMat"
    }

    // Método toString sobrescrito para mostrar información del alumno
    override fun toString(): String {
        return "$matricula - ${getNombreCompleto()}"
    }
}