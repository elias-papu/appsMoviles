//
//  CoreDataManager.swift
//  PersonitaDataApp
//
//  Created by Elías Jiménez on 30/09/24.
//

import Foundation
import CoreData

class CoreDataManager {
    let contenedor : NSPersistentContainer
    
    init() {
        contenedor = NSPersistentContainer(name: "ModelPersonita")
        contenedor.loadPersistentStores{
            (description, error) in
            if let error = error {
                fatalError("No se puede inicializar la base!!! \(error.localizedDescription) por culpa de Pedro!!!")
            }
        }
    }
    
    func guardarPersonita(nombre:String) {
        let personita = Personita(context: contenedor.viewContext)
        personita.nombre = nombre
        do {
            try contenedor.viewContext.save()
            print("Personita guardada exitosamente!!!")
        } catch {
            print("Pedro cometió un error al guardar!")
        }
    }
    
    func leerPersonitas()-> [Personita] {
        let lector: NSFetchRequest<Personita> = Personita.fetchRequest()
        do {
            return try contenedor.viewContext.fetch(lector)
        } catch {
            return []
        }
    }
    
}
