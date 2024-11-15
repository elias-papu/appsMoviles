//
//  main.swift
//  ej15_calificaciones
//
//  Created by Elías Jiménez on 22/08/24.
//

import Foundation

var profe: maestro

var mate: materia = materia(nombre: "Matemáticas", profe: maestro(nombre: "Elías"))

var alu: [alumno] = []

for x in 0...5 {
    var nombre: String = "alumno_"
    nombre = nombre + String(x)
    let n = alumno(nombre: nombre, mat: mate, calificacion: 0)
    alu.append(n)
}

var op: Int = 0
repeat {
    print("\n\tMenú")
    print("1.- Mostrar alumnos")
    print("2.- Cambiar calificaciones")
    print("3.- salir")
    op = Int(readLine() ?? "") ?? 0
    if op == 1 {
        muestra()
    }
    else if op == 2 {
        cambia()
    }
}while op != 3

func muestra() {
    for x in 0...5 {
        alu[x].saludar()
    }
}

func cambia() {
    var cal: Int
    for x in 0...5 {
        print("Calificacion del alumno: \(alu[x].nombre)")
        cal = Int(readLine() ?? "") ?? 0
        alu[x].cambiar(x: cal)
    }
}
