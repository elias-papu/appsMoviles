//
//  CoreDataManager.swift
//  PeliculotaCoreData
//
//  Created by Elías Jiménez on 08/10/24.
//

import Foundation
import CoreData

class CoreDataManager {
    let contenedor: NSPersistentContainer

    init() {
        contenedor = NSPersistentContainer(name: "ModeloPelicula")
        contenedor.loadPersistentStores { (descripcion, error) in
            if let error = error {
                fatalError("No se puede iniciar la base: \(error)")
            }
        }
    }

    func guardarPelicula(titulo: String, genero: String, director: String, duracion: String, clasificacion:String ,fecha: Date) {
        let pelicula = Pelicula(context: contenedor.viewContext)
        pelicula.titulo = titulo
        pelicula.genero = genero
        pelicula.director = director
        pelicula.duracion = duracion
        pelicula.clasificacion = clasificacion
        pelicula.fechaLanzamiento = fecha

        do {
            try contenedor.viewContext.save()
        } catch {
            print("No se pudo guardar la pelicula: \(error)")
        }
    }

    func leerPelicula() -> [Pelicula] {
        let lector: NSFetchRequest<Pelicula> = Pelicula.fetchRequest()
        do {
            return try contenedor.viewContext.fetch(lector)
        } catch {
            print("No se pudieron leer las peliculas: \(error)")
            return []
        }
    }
}
