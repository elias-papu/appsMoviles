//
//  Auto.swift
//  AutosSwift
//
//  Created by Elías Jiménez on 19/08/24.
//

import Foundation

class Auto{
    let marca:String
    let modelo:String
    var posicion:Int
    
    init(marca: String, modelo: String) { //Esto es un constructor, asigna los atributos al objeto
        self.marca = marca //Self es un apuntador a la instancia actual
        self.modelo = modelo
        self.posicion = 0
    }
    
    init(marca: String, modelo: String, posicion: Int) {
        self.marca = marca
        self.modelo = modelo
        self.posicion = posicion;
    }
    
    func avanzar() {
        posicion += 1
    }
    
    func avanzar(x: Int) {
        posicion += x
    }
    
    func imprimir() {
        print("\(marca) - \(modelo) | \(posicion) Km")
    }
}
