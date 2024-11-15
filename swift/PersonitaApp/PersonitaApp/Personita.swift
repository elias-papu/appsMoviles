//
//  Personita.swift
//  PersonitaApp
//
//  Created by Elías Jiménez on 26/08/24.
//

import Foundation

class Personita {
    var nombre: String
    var edad: Int
    
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
    
    func imprimir()-> String{
        return "Hola soy \(self.nombre) y tengo \(self.edad) años"
    }
    
}
