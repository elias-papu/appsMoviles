//
//  Personita.swift
//  PersonitaEjemplo
//
//  Created by Elías Jiménez on 19/08/24.
//

import Foundation

class Personita {
    let nombre: String
    var edad: Int
    
    
    
    init(nombre: String) {
        self.nombre = nombre
        self.edad = 0
    }
    
    init(nombre: String, edad: Int) {
        self.nombre = nombre
        self.edad = edad
    }
    
    func crecer() {
        edad += 1
    }
    
    func crecer(x: Int) {
        edad += x
    }
    
    func saludar() {
        print("Hola soy \(nombre) y tengo \(edad) años")
    }
    
}
