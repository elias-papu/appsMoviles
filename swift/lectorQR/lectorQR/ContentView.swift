//
//  ContentView.swift
//  lectorQR
//
//  Created by Elías Jiménez on 12/10/24.
//

import SwiftUI
import AVFoundation

struct ContentView: View {
    @State private var scannedCode: String?
    @State private var showAlert = false

    var body: some View {
        GeometryReader { geometry in
            VStack {
                Text("Lector de QR")
                    .font(.title)
                    .foregroundColor(.black)
                    .padding()

                if let scannedCode = scannedCode {
                    Text("Código escaneado: \(scannedCode)")
                        .padding()
                } else {
                    Text("Escanea un código QR")
                        .padding()
                }

                // Vista del lector de QR que siempre está activa
                QRCodeScannerView(didFindCode: { code in
                    // Guarda el código escaneado
                    self.scannedCode = code
                }, didFailWithError: { error in
                    print("Error al escanear: \(error.localizedDescription)")
                })
                .aspectRatio(3/4, contentMode: .fill)
                .frame(width: geometry.size.width * 0.9, height: geometry.size.height * 0.5)
                .clipShape(RoundedRectangle(cornerRadius: 20))
                .overlay(
                    RoundedRectangle(cornerRadius: 20)
                        .stroke(Color.black, lineWidth: 2)
                )
                .padding()

                // Botón que lanza la alerta con el código escaneado
                Button(action: {
                    // Si hay un código escaneado, muestra la alerta y vibra
                    if let scannedCode = scannedCode {
                        AudioServicesPlaySystemSound(SystemSoundID(kSystemSoundID_Vibrate)) // Vibra cuando se detecta el QR y se presiona el botón
                        showAlert = true
                    }
                }) {
                    Image(systemName: "qrcode.viewfinder")
                        .resizable()
                        .frame(width: 50, height: 50)
                        .padding()
                }
                .frame(width: 100, height: 100)
                .background(Color.blue)
                .foregroundColor(.white)
                .clipShape(Circle())
                .padding()
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .background(Color.white)
            .ignoresSafeArea()
            .alert(isPresented: $showAlert) {
                Alert(title: Text("Código escaneado"), message: Text(scannedCode ?? "No se ha escaneado ningún código"), dismissButton: .default(Text("OK")))
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

#Preview {
    ContentView()
}
