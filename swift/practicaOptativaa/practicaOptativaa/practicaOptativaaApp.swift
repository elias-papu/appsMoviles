//
//  practicaOptativaaApp.swift
//  practicaOptativaa
//
//  Created by Elías Jiménez on 27/10/24.
//

import SwiftUI
import FirebaseCore
import GoogleSignIn

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]? = nil) -> Bool {
        FirebaseApp.configure()  // Configuración de Firebase al iniciar
        return true
    }
    
    // Implementación necesaria para que Google Sign-In funcione correctamente
    func application(_ app: UIApplication, open url: URL,
                     options: [UIApplication.OpenURLOptionsKey : Any] = [:]) -> Bool {
        return GIDSignIn.sharedInstance.handle(url)
    }
}

@main
struct practicaOptativaaApp: App {
    // Registramos el delegado de la aplicación para configurar Firebase
    @UIApplicationDelegateAdaptor(AppDelegate.self) var delegate
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
