//
//  Calificacion.h
//  materiasObjectiveC
//
//  Created by Elías Jiménez on 23/08/24.
//

#import <Foundation/Foundation.h>
#import "Materia.h"

@interface Calificacion : NSObject

@property Materia *materia;
@property float nota;

- (id)initWithMateria:(Materia *)materia nota:(float)nota;

@end
