//
//  main.swift
//  EjemploCliente
//
//  Created by Elías Jiménez on 28/10/24.
//

import Foundation
import Network

class Cliente: Codable {
    var noCliente: Int
    var nombre: String
    var apellidoPaterno: String
    var apellidoMaterno: String
    var fechaNacimiento: Date
    var sexo: String
    
    init(nombre: String, apellidoPaterno: String, apellidoMaterno: String, fechaNacimiento: Date, sexo: String) {
        self.noCliente = 0
        self.nombre = nombre
        self.apellidoPaterno = apellidoPaterno
        self.apellidoMaterno = apellidoMaterno
        self.fechaNacimiento = fechaNacimiento
        self.sexo = sexo
    }
}

let miCliente = Cliente(nombre: "Elías", apellidoPaterno: "Jiménez", apellidoMaterno: "Hernández", fechaNacimiento: Date(), sexo: "M")

var formatter: DateFormatter = DateFormatter()
formatter.dateFormat = "yyyy-MM-dd"
let jsonEncoder = JSONEncoder()
jsonEncoder.dateEncodingStrategy = .formatted(formatter)
let jsonData = try jsonEncoder.encode(miCliente)
let jsonCadena = String(data: jsonData, encoding: String.Encoding.utf8)
print(jsonCadena ?? "")

//Deserealizar

let jsonDecoder = JSONDecoder()
jsonDecoder.dateDecodingStrategy = .formatted(formatter)
let nuevoCliente = try jsonDecoder.decode(Cliente.self, from: jsonData)

print(nuevoCliente.nombre)
