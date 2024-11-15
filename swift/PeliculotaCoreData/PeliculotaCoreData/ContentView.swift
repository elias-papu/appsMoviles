//
//  ContentView.swift
//  PeliculotaCoreData
//
//  Created by Elías Jiménez on 08/10/24.
//

import SwiftUI

struct ContentView: View {
    let coreDataManager = CoreDataManager()
    @State private var titulo: String = ""
    @State private var director: String = ""
    @State private var duracion: String = ""
    @State private var date = Date()
    enum clasificacion: String, CaseIterable, Identifiable {
        case A, AA, B, B15, C, R
        var id: Self { self }
    }
    enum genero: String, CaseIterable, Identifiable {
        case seleccionar, Drama, Comedia, CienciaFiccion, Terrror, Suspenso, Infantil
        var id: Self { self }
    }
    @State private var peli: [Pelicula] = [Pelicula]()
    private func leerPelicula() {
        peli = coreDataManager.leerPelicula()
    }

    @State private var gen: genero = .seleccionar
    @State private var cla: clasificacion = .A
    
    var body: some View {
        VStack {
            HStack {
                Image(systemName: "movieclapper.fill")
                    .imageScale(.large)
                    .foregroundStyle(.blue)
                Text("Peliculota")
                Image(systemName: "movieclapper.fill")
                    .imageScale(.large)
                    .foregroundStyle(.blue)
            }
            TextField("Ingrese el título: ", text: $titulo)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            TextField("Ingrese el director: ", text: $director)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            TextField("Ingrese la duración: ", text: $duracion)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            DatePicker("Fecha de lanzamiento",
                       selection: $date,
                       displayedComponents: [.date])
            HStack {
                Text("Género")
                
                
                Picker("Seleccionar", selection: $gen) {
                    Text("Seleccionar").tag(genero.seleccionar)
                    Text("Drama").tag(genero.Drama)
                    Text("Comedia").tag(genero.Comedia)
                    Text("Ciencia Ficción").tag(genero.CienciaFiccion)
                    Text("Terrror").tag(genero.Terrror)
                    Text("Suspenso").tag(genero.Suspenso)
                    Text("Infantil").tag(genero.Infantil)
                }
                .pickerStyle(.menu)
            }
            HStack {
                Text("Clasificación")
                
                
                Picker("Seleccionar", selection: $cla) {
                    Text("A").tag(clasificacion.A)
                    Text("AA").tag(clasificacion.AA)
                    Text("B").tag(clasificacion.B)
                    Text("B15").tag(clasificacion.B15)
                    Text("C").tag(clasificacion.C)
                    Text("R").tag(clasificacion.R)
                }
                .pickerStyle(.segmented)
            }
            Button("Guardar") {
                if !titulo.isEmpty && !director.isEmpty && !duracion.isEmpty{
                    coreDataManager.guardarPelicula(titulo: titulo, genero: gen.rawValue, director: director, duracion: duracion, clasificacion: cla.rawValue, fecha: date)
                    
                    print("Pelicula guardada!!")
                    titulo = ""
                    director = ""
                    duracion = ""
                    date = Date()
                    gen = .seleccionar
                    cla = .A
                    leerPelicula()
                }
                else {
                    print("Tienes que completar los campos")
                }
            }
            List {
                ForEach(peli, id: \.self) { pelicula in
                    VStack(alignment: .leading) {
                        Text("Título: \(pelicula.titulo ?? "")")
                        Text("Director: \(pelicula.director ?? "")")
                        Text("Clasificación: \(pelicula.clasificacion ?? "")")
                        Text("Duración: \(pelicula.duracion ?? "")")
                        Text("Género: \(pelicula.genero ?? "")")
                        if let fecha = pelicula.fechaLanzamiento {
                            Text("Fecha de Lanzamiento: \(fecha, formatter: dateFormatter)")
                        }
                    }
                    .padding()
                }
            }
            Spacer()
        }
        .padding()
        .onAppear(perform: {leerPelicula()})
    }
}

private let dateFormatter: DateFormatter = {
    let formatter = DateFormatter()
    formatter.dateStyle = .medium // Puedes ajustar el estilo aquí
    formatter.timeStyle = .none
    return formatter
}()


#Preview {
    ContentView()
}
