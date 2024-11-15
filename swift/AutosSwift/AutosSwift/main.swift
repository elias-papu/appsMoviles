//
//  main.swift
//  AutosSwift
//
//  Created by Elías Jiménez on 19/08/24.
//

import Foundation

var miVocho: Auto
var miFerrari: Auto = Auto(marca: "Ferrari", modelo: "Clasico") //IMPORTANTE, aquí los nombres de las variables si deben estar en la declaración

miVocho = Auto(marca: "VW", modelo: "Sedán")

miVocho.imprimir()
miFerrari.imprimir()

miVocho.avanzar(x: 100)
miFerrari.avanzar(x: 200)

miVocho.imprimir()
miFerrari.imprimir()

var miCoche: Auto

miCoche = miVocho

miCoche.imprimir()

miCoche.avanzar(x: 70)

miCoche.imprimir()

miVocho.imprimir() //INLCUIR EN PRÁCTICA
