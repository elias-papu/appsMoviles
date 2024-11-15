//
//  ContentView.swift
//  pruebaUI
//
//  Created by Elías Jiménez on0 22/09/24.
//

import SwiftUI

struct ContentView: View {
    @State private var monto = ""
    @State private var porcentaje = 15
    var totalPerPerson: Double {
        let bill = Double(monto) ?? 0
        let tip = bill * Double(porcentaje) / 100
        return bill + tip
    }
    var body: some View {
        VStack {
            Text("Calculadora de Propinas")
                .font(.largeTitle)
                .padding(.bottom, 20)
            
            TextField("Monto", text: $monto)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .keyboardType(.decimalPad)
                .padding()
            
            Text("Porcentaje de Propina: \(porcentaje)%")
                .padding(.bottom, 20)
            
            Slider(value: Binding(get: {
                Double(self.porcentaje)
            },set: {
                self.porcentaje = Int($0)
            }), in: 0...30, step: 1)
                .padding([.leading, .trailing], 20)
            
            Text("Total a Pagar: $\(totalPerPerson, specifier: "%.2f")")
                .font(.title)
                .foregroundColor(.green)
                .padding(.top, 20)
            
            Spacer()
        }
        .padding()
    }
}
struct TipCalculatorView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
