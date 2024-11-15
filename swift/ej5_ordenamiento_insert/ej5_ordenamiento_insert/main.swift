//
//  main.swift
//  ej5_ordenamiento_insert
//
//  Created by Elías Jiménez on 21/08/24.
//

import Foundation

var X = [6, 9, 7, 2, 5, 3]

for i in 1..<X.count {
    let key = X[i]
    var j = i - 1
    
    while j >= 0 && X[j] > key {
        X[j + 1] = X[j]
        j -= 1
    }
    
    X[j + 1] = key
}

print(X)


