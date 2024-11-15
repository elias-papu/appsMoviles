//
//  ContentView.swift
//  practicaOptativaa
//
//  Created by Elías Jiménez on 27/10/24.
//

import SwiftUI
import Firebase
import FirebaseAuth
import GoogleSignIn

struct ContentView: View {
    @State private var inicioExitoso = false
    @State private var nombre: String = ""
    @State private var correo: String = ""
    var body: some View {
        if inicioExitoso {
            ExitosoView(nombre: $nombre, correo: $correo)
        }
        VStack {
            Text("Botón de inicio de sesión con google")
                .font(.system(size: 36, weight: .bold, design: .rounded))
                .foregroundColor(.blue)
                .padding(.top, 100)
                .padding(.bottom, 150)
            Button(action: {
                print("Iniciar sesión con Google")
                signInWithGoogle()
            }) {
                HStack {
                    Image("google")
                        .resizable()
                        .frame(width: 40, height: 40)
                    
                    Text("Continuar con Google")
                        .font(.system(size: 16, weight: .bold, design: .default))
                }
                .frame(maxWidth: .infinity)
                .padding(8)
                .background(Color.white)
                .foregroundColor(.black)
                .cornerRadius(10)
                .shadow(color: .gray, radius: 5, x: 0, y: 1)
            }
            .padding(.horizontal, 20)
            Spacer()
        }
        .padding()
    }
    func signInWithGoogle() {
        GIDSignIn.sharedInstance.signIn(withPresenting: getRootViewController()) { result, error in
            if let error = error {
                print("Error al iniciar sesión con Google: \(error.localizedDescription)")
                return
            }
            
            guard let user = result?.user,
                  let idToken = user.idToken?.tokenString else {
                print("Error: No se pudo obtener el token de Google.")
                return
            }
            
            nombre = user.profile?.name ?? "Nombre desconocido"
            correo = user.profile?.email ?? "Correo desconocido"
            
            let credential = GoogleAuthProvider.credential(withIDToken: idToken, accessToken: user.accessToken.tokenString)
            
            Auth.auth().signIn(with: credential) { authResult, error in
                if let error = error {
                    print("Error al autenticar con Firebase: \(error.localizedDescription)")
                } else {
                    print("Inicio de sesión con Google exitoso")
                    print("Nombre: \(nombre), Correo: \(correo)")
                    inicioExitoso = true
                }
            }
        }
    }
    func getRootViewController() -> UIViewController {
        guard let window = UIApplication.shared.connectedScenes
            .filter({ $0.activationState == .foregroundActive })
            .compactMap({ $0 as? UIWindowScene })
            .first?.windows
            .filter({ $0.isKeyWindow }).first else {
            fatalError("No se pudo encontrar la ventana raíz")
        }
        return window.rootViewController!
    }
}

#Preview {
    ContentView()
}
