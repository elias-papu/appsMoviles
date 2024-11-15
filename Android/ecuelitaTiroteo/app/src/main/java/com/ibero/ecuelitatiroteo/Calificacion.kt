package com.ibero.ecuelitatiroteo

import java.text.SimpleDateFormat
import java.util.Date

class Calificacion{
    var materia: Materia? = null
    var calificacion: Double = 0.0
    var fecha: Date? = null

    constructor() {
        fecha = Date()
    }
    constructor(materia: Materia?, calificacion: Double) {
        this.materia = materia
        this.calificacion = calificacion
    }

    fun setFecha(fecha: String, formatoFecha: String) {
        val formato = SimpleDateFormat(formatoFecha)
        try {
            this.fecha = formato.parse(fecha) ?: Date()
        } catch (ex: Exception) {
            this.fecha = Date()
        }
    }

    fun leerFechaFormato(): String {
        val formato = SimpleDateFormat("yyyy-MM-dd")
        return formato.format(fecha ?: Date())
    }

    override fun toString(): String {
        return "$materia: ${String.format("%1$,.2f", calificacion)}"
    }
}

