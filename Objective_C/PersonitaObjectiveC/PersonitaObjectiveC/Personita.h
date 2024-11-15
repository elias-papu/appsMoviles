//
//  Personita.h
//  PersonitaObjectiveC
//
//  Created by Elías Jiménez on 21/08/24.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Personita : NSObject

@property NSString *nombre;
@property int edad;

- (id) initWithNombre: (NSString*) nombre;  //El - es un método de objeto y el + es un método de clase
- (void) saludar;
@end

NS_ASSUME_NONNULL_END
