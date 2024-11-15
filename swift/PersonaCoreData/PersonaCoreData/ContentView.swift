//
//  ContentView.swift
//  PersonaCoreData
//
//  Created by Elías Jiménez on 03/10/24.
//

import SwiftUI

struct ContentView: View {
    let coreDataManager = CoreDataManager()
    @State private var nombre: String = ""
    @State private var apPat: String = ""
    @State private var apMat: String = ""
    @State private var date = Date()
    enum sexo: String, CaseIterable, Identifiable {
        case seleccionar, masculino, femenino
        var id: Self { self }
    }
    @State private var persona: [Persona] = [Persona]()
    private func leerPersona() {
        persona = coreDataManager.leerPersona()
    }

    @State private var sex: sexo = .seleccionar
    
    var body: some View {
        VStack {
            HStack {
                Image(systemName: "person.fill")
                    .imageScale(.large)
                    .foregroundStyle(.blue)
                Text("Personota")
                Image(systemName: "person.fill")
                    .imageScale(.large)
                    .foregroundStyle(.blue)
            }
            TextField("Ingrese su nombre: ", text: $nombre)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            TextField("Ingrese su apellido paterno: ", text: $apPat)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            TextField("Ingrese apellido materno: ", text: $apMat)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            DatePicker("Fecha de nacimiento",
                       selection: $date,
                       displayedComponents: [.date])
            HStack {
                Text("Sexo") // Aquí se muestra el texto de la etiqueta
                
                
                Picker("Seleccionar", selection: $sex) {
                    Text("Seleccionar").tag(sexo.seleccionar)
                    Text("Masculino").tag(sexo.masculino)
                    Text("Femenino").tag(sexo.femenino)
                }
                .pickerStyle(.segmented)
            }
            Button("Guardar") {
                if !nombre.isEmpty && !apPat.isEmpty && !apMat.isEmpty{
                    coreDataManager.guardarPersona(nombre: nombre, apPat: apPat, apMat: apMat, sexo: sex.rawValue, fecha: date)
                    
                    print("Persona guardada!!")
                    nombre = ""
                    apPat = ""
                    apMat = ""
                    date = Date()
                    sex = .seleccionar
                    leerPersona()
                }
                else {
                    print("Tienes que completar los campos")
                }
            }
            List {
                ForEach(persona, id: \.self) {
                    persona in Text(persona.nombre ?? "")
                }
            }
            Spacer()
        }
        .padding()
        .onAppear(perform: {leerPersona()})
    }
}

#Preview {
    ContentView()
}
