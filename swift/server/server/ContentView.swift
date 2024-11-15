//
//  ContentView.swift
//  server
//
//  Created by Elías Jiménez on 24/10/24.
//

import SwiftUI

struct ContentView: View {
    @State private var output = "Esperando respuesta..."
    
    var body: some View {
        VStack(spacing: 20) {
            // Botón para conectarse vía SSH y ejecutar el comando
            Button(action: {
                conectarSSH()
            }) {
                Text("Conectar vía SSH")
                    .bold()
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.green)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }
            
            // Mostrar la salida del comando
            Text(output)
                .padding()
                .multilineTextAlignment(.center)
        }
        .padding()
    }
    
    // Función para conectarse al servidor vía SSH y ejecutar el comando
    func conectarSSH() {
        let session = SSH(host: "184.168.23.165", port: 22)
        session.connect(username: "tu-usuario", password: "tu-contraseña") { error in
            if let error = error {
                print("Error de conexión SSH: \(error.localizedDescription)")
                self.output = "Error de conexión"
            } else {
                print("Conexión SSH exitosa")
                self.output = "Conexión exitosa"

                // Ejecutar un comando en el servidor
                session.authenticate(username: "tu-usuario", password: "tu-contraseña") { error in
                    if let error = error {
                        print("Error de autenticación SSH: \(error.localizedDescription)")
                        self.output = "Error de autenticación"
                    } else {
                        session.execute("uptime") { result in
                            switch result {
                            case .success(let response):
                                print("Respuesta del servidor: \(response)")
                                self.output = "Respuesta: \(response)"
                            case .failure(let error):
                                print("Error ejecutando comando: \(error.localizedDescription)")
                                self.output = "Error ejecutando comando"
                            }
                            session.disconnect()
                        }
                    }
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

