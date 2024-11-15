//
//  ExitosoView.swift
//  practicaOptativaa
//
//  Created by Elías Jiménez on 27/10/24.
//

import SwiftUI

struct ExitosoView: View {
    @Binding var nombre: String
    @Binding var correo: String
    var body: some View {
        Text("Inicio de sesión exitoso")
        Text("Bienvenido \(nombre)")
        Text("Correo: \(correo)")
    }
}

struct CalculadoraPreviewWrapper: View {
    @State var nombre: String = "Elías"
    @State var correo: String = "eliasjh.gg@gmail.com"

    var body: some View {
        ExitosoView(nombre: $nombre, correo: $correo)
    }
}


extension View {
    @ViewBuilder func hidden(_ shouldHide: Bool) -> some View {
        if shouldHide {
            self.hidden()
        } else {
            self
        }
    }
}
