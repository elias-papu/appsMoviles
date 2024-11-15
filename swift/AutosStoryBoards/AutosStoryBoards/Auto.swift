//
//  Auto.swift
//  AutosStoryBoards
//
//  Created by Elías Jiménez on 02/09/24.
//

import Foundation

class Auto {
    var marca: String
    var modelo: String
    var posicion: Int
    
    init() {
        marca = ""
        modelo = ""
        posicion = 0
    }
    
    init(marca:String, modelo:String) {
        self.modelo = modelo
        self.marca = marca
        self.posicion = 0
    }
    
    init(marca:String, modelo:String, posicion:Int) {
        self.modelo = modelo
        self.marca = marca
        self.posicion = posicion
    }
    
    func avanzar() {
        posicion += 1
    }
    
    func avanzar(x: Int) {
        posicion += x
    }
    
    func imprimir() -> String {
        return "\(marca) \(modelo) | \(posicion) Km"
    }
}
