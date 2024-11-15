//
//  auto.m
//  autosObectiveC
//
//  Created by Elías Jiménez on 23/08/24.
//

#import "auto.h"

@implementation Auto

- (id) initSinP: (NSString*) marca modelo: (NSString*) modelo {
    self = [super init];
    _marca = marca;
    _modelo = modelo;
    _posicion = 0;
    return self;
}

- (void) mover {
    _posicion += 1;
}

- (void) moverX: (int) x {
    _posicion += x;
}

- (void) mostrar {
    NSLog(@"%@ - %@ | %d Km", _marca, _modelo, _posicion);
}

@end
