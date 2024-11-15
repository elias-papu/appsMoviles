//
//  auto.h
//  autosObectiveC
//
//  Created by Elías Jiménez on 23/08/24.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Auto : NSObject

@property NSString *marca;
@property NSString *modelo;
@property int posicion;

- (id) initSinP: (NSString*) marca modelo: (NSString*) modelo;

- (void) mover;

- (void) moverX: (int) x;

- (void) mostrar;
@end

NS_ASSUME_NONNULL_END
