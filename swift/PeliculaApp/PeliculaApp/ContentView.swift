//
//  ContentView.swift
//  PeliculaApp
//
//  Created by Elías Jiménez on 30/09/24.
//

import SwiftUI
import CoreData

struct ContentView: View {
    let coreDataManager = CoreDataManager()
    @State private var tituloPeli: String = ""
    @State private var pelis: [Pelicula] = [Pelicula]()
    
    private func leerPelis() {
        pelis = coreDataManager.leerPelis()
    }
    
    var body: some View {
        VStack {
            HStack {
                Image(systemName: "movieclapper.fill")
                    .imageScale(.large)
                    .foregroundStyle(.orange)
                Text("Mis Películas Favoritas")
                Image(systemName: "popcorn.fill")
                    .imageScale(.large)
                    .foregroundStyle(.orange)
            }
            TextField("Ingrese Título de la Película: ", text: $tituloPeli)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            
            Button("Guardar") {
                if !tituloPeli.isEmpty {
                    coreDataManager.guardarPeli(titulo: tituloPeli)
                    leerPelis()
                    print("Película guardada!!")
                    tituloPeli = ""
                }
                else {
                    print("Tienes que ponerle nombre a la película")
                }
            }
            List {
                ForEach(pelis, id: \.self) {
                    peli in Text(peli.titulo ?? "")
                }
            }
            Spacer()
        }
        .padding()
        .onAppear(perform: {leerPelis()})
    }
}

#Preview {
    ContentView()
}
