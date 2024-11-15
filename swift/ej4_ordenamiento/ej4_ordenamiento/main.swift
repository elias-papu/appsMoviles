//
//  main.swift
//  ej4_ordenamiento
//
//  Created by Elías Jiménez on 21/08/24.
//
import Foundation

var X = [6, 9, 7, 2, 5, 3]
var n = X.count
var temp: Int

for x in 1..<n {
    for i in 0..<n-1 {
        if X[i] > X[i+1] {
            temp = X[i]
            X[i] = X[i+1]
            X[i+1] = temp
        }
    }
}

print(X)
