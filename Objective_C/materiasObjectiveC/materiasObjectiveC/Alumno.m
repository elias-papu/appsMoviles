//
//  Alumno.m
//  materiasObjectiveC
//
//  Created by Elías Jiménez on 23/08/24.
//

#import "Alumno.h"

@implementation Alumno

- (id)initWithNombre: (NSString *)nombre apellido: (NSString *)apellido{
    self = [super init];
    _calificaciones = [[NSMutableArray alloc] init];
    _nombre = nombre;
    return self;
}

- (void)agregarCalificacion:(Calificacion *)calificacion {
    [self.calificaciones addObject:calificacion];
}

- (float)calcularPromedio {
    float suma = 0.0;
    for (Calificacion *calificacion in self.calificaciones) {
        suma += calificacion.nota;
    }
    return suma / self.calificaciones.count;
}

@end
