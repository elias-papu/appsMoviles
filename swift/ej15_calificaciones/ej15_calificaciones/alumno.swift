//
//  alumno.swift
//  ej15_calificaciones
//
//  Created by Elías Jiménez on 22/08/24.
//

import Foundation

class alumno {
    let nombre: String
    let mat: materia
    var calificacion: Int
    
    init(nombre: String, mat: materia, calificacion: Int) {
        self.nombre = nombre
        self.mat = mat
        self.calificacion = calificacion
    }
    func cambiar(x: Int) {
        calificacion = x
    }
    func saludar() {
        print("Alumno: \(nombre)\nMateria: \(mat.nombre)\nProfesor: \(mat.profe.nombre)\nCalificación: \(calificacion)")
    }
}
