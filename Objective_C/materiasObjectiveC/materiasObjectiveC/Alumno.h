//
//  Alumno.h
//  materiasObjectiveC
//
//  Created by Elías Jiménez on 23/08/24.
//

#import <Foundation/Foundation.h>
#import "Calificacion.h"

@interface Alumno : NSObject

@property NSString *nombre;
@property NSString *apellido;
@property NSMutableArray<Calificacion *> *calificaciones;

- (id)initWithNombre: (NSString *)nombre apellido: (NSString *)apellido;
- (void)agregarCalificacion:(Calificacion *)calificacion;
- (float)calcularPromedio;

@end
