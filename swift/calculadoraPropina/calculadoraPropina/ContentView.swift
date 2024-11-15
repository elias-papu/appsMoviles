//
//  ContentView.swift
//  calculadoraPropina
//
//  Created by Elías Jiménez on 20/09/24.
//

import SwiftUI

struct ContentView: View {
    
    @State var monto = "1000"
    @State var porcentaje = 10.0
    
    
    
    var body: some View {
        VStack {
            HStack {
                Image(systemName: "dollarsign.circle.fill")
                    .imageScale(.large)
                    .foregroundStyle(.green)
                Text("Calculadora de Propinas")
                Image(systemName: "dollarsign.circle.fill")
                    .imageScale(.large)
                    .foregroundStyle(.green)
            }
            HStack {
                Text("$")
                TextField("Monto", text: $monto)
                Text(monto)
            }
            HStack {
                Slider(value: $porcentaje, in: 5...100, step: 5)
                Text(String(porcentaje))
            }
            HStack {
                Text("Propina:")
                if let total = Double(monto) {
                    let propina = total * porcentaje / 100
                    let monto_total = (Double(monto) ?? 0) + (propina)
                    Text(String(propina))
                    Text("Total: " + String(monto_total))
                }
                else {
                    Text("Debes ingresar el monto en moneda")
                        .foregroundStyle(.red)
                }
            }
            Spacer()
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
