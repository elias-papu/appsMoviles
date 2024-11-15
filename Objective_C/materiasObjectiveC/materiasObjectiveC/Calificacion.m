//
//  Calificacion.m
//  materiasObjectiveC
//
//  Created by Elías Jiménez on 23/08/24.
//

#import "Calificacion.h"

@implementation Calificacion

- (id)initWithMateria:(Materia *)materia nota:(float)nota {
    self = [super init];

    _materia = materia;
    _nota = nota;
    return self;
}

@end
