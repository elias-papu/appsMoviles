package com.example.personotasqlite

class Personita {
    var nombre: String? = null
    var apPat: String? = null
    var apMat: String? = null
    var nacimiento: String? = null
    var sexo: String? = null

    constructor()

    constructor(nombre: String?, apPat: String?, apMat: String?, nacimiento: String?, sexo: String?) {
        this.nombre = nombre
        this.apPat = apPat
        this.apMat = apMat
        this.nacimiento = nacimiento
        this.sexo = sexo
    }


    override fun toString(): String {
        return "Nombre: ${nombre ?: ""}, Apellido Paterno: ${apPat ?: ""}, Apellido Materno: ${apMat ?: ""}, Fecha de Nacimiento: ${nacimiento ?: ""}, Sexo: ${sexo ?: ""}"
    }
}