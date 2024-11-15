//
//  CoreDataManager.swift
//  PersonaCoreData
//
//  Created by Elías Jiménez on 08/10/24.
//

import Foundation
import CoreData

class CoreDataManager {
    let contenedor: NSPersistentContainer

    init() {
        contenedor = NSPersistentContainer(name: "ModeloPersona")
        contenedor.loadPersistentStores { (descripcion, error) in
            if let error = error {
                fatalError("No se puede iniciar la base: \(error)")
            }
        }
    }

    func guardarPersona(nombre: String, apPat: String, apMat: String, sexo: String, fecha: Date) {
        let persona = Persona(context: contenedor.viewContext)
        persona.nombre = nombre
        persona.apPat = apPat
        persona.apMat = apMat
        persona.sexo = sexo
        persona.nacimiento = fecha

        do {
            try contenedor.viewContext.save()
        } catch {
            print("No se pudo guardar la persona: \(error)")
        }
    }

    func leerPersona() -> [Persona] {
        let lector: NSFetchRequest<Persona> = Persona.fetchRequest()
        do {
            return try contenedor.viewContext.fetch(lector)
        } catch {
            print("No se pudieron leer las personas: \(error)")
            return []
        }
    }
}

