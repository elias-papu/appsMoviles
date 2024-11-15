//
//  main.m
//  HolaObjectiveC
//
//  Created by Elías Jiménez on 21/08/24.
//

#import <Foundation/Foundation.h>

int main(void) {
    
    BOOL meAma = NO;
    BOOL laAmo = YES;
    NSString *nombre = @"Elías";
    NSString *mayusculas;
    NSString *ola;
    
    NSDate *miFecha;
    //miFecha = [NSDate alloc];
    //miFecha = [miFecha init];
    miFecha = [[NSDate alloc] init];
    
    ola = nombre;
    ola = @"papu";
    mayusculas = [nombre uppercaseString];
    @autoreleasepool {
        // insert code here...
        
        NSLog(@"Hola mundo en Objetive C, mi nombre es %@", mayusculas);
        NSLog(@"%@", miFecha);
    }
    return 0;
}
