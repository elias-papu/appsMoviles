package com.ibero.ecuelitatiroteo

class Materia {
    var clave: String? = null
    var nombre: String? = null
    var creditos: Int=10

    constructor() {
        creditos = 10
    }

    constructor(clave: String?, nombre: String?) {
        this.clave = clave
        this.nombre = nombre
        creditos = 10
    }

    constructor(clave: String?, nombre: String?, creditos: Int) {
        this.clave = clave
        this.nombre = nombre
        this.creditos = creditos
    }

    override fun toString(): String {
        return "$clave - $nombre)"
    }
}
