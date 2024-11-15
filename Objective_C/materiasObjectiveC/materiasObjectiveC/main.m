//
//  main.m
//  materiasObjectiveC
//
//  Created by Elías Jiménez on 23/08/24.
//

#import <Foundation/Foundation.h>
#import "Alumno.h"
#import "Materia.h"
#import "Calificacion.h"

int main(void) {
    @autoreleasepool {
        Materia *matematicas = [[Materia alloc] initWithNombre:@"Matemáticas"];
        Materia *espanol = [[Materia alloc] initWithNombre:@"Español"];

        Alumno *alumno1 = [[Alumno alloc] initWithNombre: @"Elías" apellido: @"Jiménez"];

        Calificacion *calificacion1 = [[Calificacion alloc] initWithMateria:matematicas nota:9.5];
        Calificacion *calificacion2 = [[Calificacion alloc] initWithMateria:espanol nota:8.0];

        [alumno1 agregarCalificacion:calificacion1];
        [alumno1 agregarCalificacion:calificacion2];

        float promedio = [alumno1 calcularPromedio];
        NSLog(@"El promedio de %@ %@ es: %.2f", alumno1.nombre, alumno1.apellido, promedio);

        for (Calificacion *calificacion in alumno1.calificaciones) {
            NSLog(@"Calificación en %@: %.2f", calificacion.materia.nombre, calificacion.nota);
        }
    }
    return 0;
}

