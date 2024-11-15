//
//  main.swift
//  obeja_xd
//
//  Created by Elías Jiménez on 16/08/24.
//

import Foundation

var pregunta:String = ""
var oveja:Int = 0

print("Ya me dormí?")
pregunta = readLine() ?? ""

while(pregunta != "si") {
    print("Ya me dormí?")
    pregunta = readLine() ?? ""
    oveja += 1
}

print("Ovejas contadas: \(oveja)")

