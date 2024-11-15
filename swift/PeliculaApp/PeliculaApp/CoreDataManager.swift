//
//  CoreDataManager.swift
//  PeliculaApp
//
//  Created by Elías Jiménez on 30/09/24.
//

import Foundation
import CoreData

class CoreDataManager {
    let contenedor:NSPersistentContainer
    init() {
        contenedor = NSPersistentContainer(name: "ModeloPelicula")
        contenedor.loadPersistentStores() {
            (descripcion, error) in
            if let error = error {
                fatalError("No se puede inicar la base por culpa de Pedro")
            }
        }
    }
    func guardarPeli(titulo:String) {
        let peli = Pelicula(context: contenedor.viewContext)
        peli.titulo = titulo
        do{
            try contenedor.viewContext.save()
        }catch {
            print("No funciona por culpa de Pedro")
        }
    }
    func leerPelis() -> [Pelicula] {
        let lector: NSFetchRequest<Pelicula> = Pelicula.fetchRequest()
        do {
            return try contenedor.viewContext.fetch(lector)
        }catch {
            return []
        }
    }
}
