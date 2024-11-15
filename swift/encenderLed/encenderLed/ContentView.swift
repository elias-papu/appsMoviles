//
//  ContentView.swift
//  encenderLed
//
//  Created by Elías Jiménez on 30/10/24.
//

import SwiftUI

struct ContentView: View {
    @State private var angle: Double = 90  // Ángulo inicial
    let serverURL = "http://172.20.10.2:8081/servo"  // IP del servidor de la Pico

    var body: some View {
        VStack {
            Text("Control de Servomotor")
                .font(.largeTitle)
                .fontWeight(.bold)
                .foregroundColor(.blue)
                .padding(.bottom, 20)
            
            Text("Ángulo: \(Int(angle))°")
                .font(.title2)
                .foregroundColor(.gray)
            
            Slider(value: $angle, in: 0...180, step: 1, onEditingChanged: { _ in
                sendAngleToServer(angle: Int(angle))
            })
            .padding()
            
            Spacer()
        }
        .padding()
    }
    
    // Función para enviar el ángulo al servidor
    func sendAngleToServer(angle: Int) {
        guard let url = URL(string: serverURL) else { return }
        
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.setValue("application/x-www-form-urlencoded", forHTTPHeaderField: "Content-Type")
        
        let bodyData = "angle=\(angle)"
        request.httpBody = bodyData.data(using: .utf8)
        
        URLSession.shared.dataTask(with: request) { data, response, error in
            if let error = error {
                print("Error al enviar el ángulo: \(error.localizedDescription)")
            }
            if let data = data {
                print("Respuesta del servidor:", String(data: data, encoding: .utf8) ?? "Sin respuesta")
            }
        }.resume()
    }
}

#Preview {
    ContentView()
}
