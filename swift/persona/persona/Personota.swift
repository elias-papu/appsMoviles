//
//  Personota.swift
//  persona
//
//  Created by Elías Jiménez on 29/08/24.
//

import Foundation

class Personota {
    var nombre: String
    var apPat: String
    var apMat: String
    var mail: String
    var tel: String
    var edad: Int
    
    init(nombre: String, apPat: String, apMat: String, mail: String, tel: String, edad: Int) {
        self.nombre = nombre
        self.apMat = apMat
        self.apPat = apPat
        self.mail = mail
        self.tel = tel
        self.edad = edad
    }
    func imprimir()-> String{
        return "Hola \(self.nombre) \(self.apPat) \(self.apMat), tienes \(self.edad) años\ntu teléfono es \(self.tel) y tu e-mail es \(self.mail)"
    }
}
