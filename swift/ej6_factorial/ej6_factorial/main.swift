//
//  main.swift
//  ej6_factorial
//
//  Created by Elías Jiménez on 21/08/24.
//

import Foundation

var x: Int

print("Dame un número: ")
x = Int(readLine() ?? "") ?? 0

func factorial(x: Int) -> Int {
    if x < 1 {
        return 1
    }
    else {
        return x * factorial(x:x-1)
    }
}

func iteracion(x: Int) {
    var n: Int = x
    var res: Int = x
    while(n > 1) {
        res *= n - 1
        n = n - 1
    }
    print("\(res)")
}

print("\(factorial(x: x))")

iteracion(x: x)
