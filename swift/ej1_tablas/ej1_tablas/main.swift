//
//  main.swift
//  ej1_tablas
//
//  Created by Elías Jiménez on 16/08/24.
//

import Foundation

func tablas(num: Int) -> [Int] {
    var a: [Int] = []
    for x in 1...10 {
        a.append(num * x)
    }
    return a
}

var num:Int
print("Escribe un número para su tabla: ")

num = Int(readLine() ?? "") ?? 0
print(tablas(num:num))
