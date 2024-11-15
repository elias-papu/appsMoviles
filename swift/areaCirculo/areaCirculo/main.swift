//
//  main.swift
//  areaCirculo
//
//  Created by Elías Jiménez on 16/08/24.
//

import Foundation

var radio:Float
var r_2:Float = 0.0
print("Dame el radio del círculo, llamada por valor: ")

radio = Float(readLine() ?? "") ?? 0

func areaValor(r:Float)->Float {
    return (r * r) * 3.14159265
}

func areaRef(r_2: inout Float) {
    print("Dame el radio del círculo, llamada por referencia: ")
    r_2 = Float(readLine() ?? "") ?? 0
}

print("El valor para el área del círculo con r = \(radio) es \(areaValor(r: radio)), calculado con valor")

areaRef(r_2: &r_2)
print("El valor para el área del círculo con r = \(r_2) es \(((r_2 * r_2) * 3.141592)), calculado por referencia")
