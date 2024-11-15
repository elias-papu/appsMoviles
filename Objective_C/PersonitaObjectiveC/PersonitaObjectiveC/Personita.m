//
//  Personita.m
//  PersonitaObjectiveC
//
//  Created by Elías Jiménez on 21/08/24.
//

#import "Personita.h"

@implementation Personita

- (id) init {
    self = [super init];
    _nombre = @"Sin nombre";
    _edad = 0;
    return self;
}

- (id) initWithNombre: (NSString*) nombre {
    self = [super init];
    _nombre = nombre;
    _edad = 0;
    return self;
}

- (void) saludar {
   NSLog(@"Hola, soy %@ y tengo %d años\n", _nombre, _edad);
}

@end
