//
//  main.swift
//  funciones
//
//  Created by Elías Jiménez on 16/08/24.
//

import Foundation

func sumar(x:Int, y:Int)->Int {
    let z:Int = x+y
    return z
}

var num1:Int
var num2:Int
var resultado:Int

print("Dame el primer número: ")
num1 = Int(readLine() ?? "") ?? 0
print("Dame el segundo número: ")
num2 = Int(readLine() ?? "") ?? 0

resultado = sumar(x: num1, y: num2)

print("La suma de \(num1) y \(num2) es \(resultado)")
print("Ejemplo de suma automática: \(sumar(x:9, y:5))")
