//
//  main.m
//  PersonitaObjectiveC
//
//  Created by Elías Jiménez on 21/08/24.
//

#import <Foundation/Foundation.h>
#import "Personita.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        Personita *fulanito;
        
        fulanito = [Personita alloc];
        [fulanito setNombre: @"Perdo Pedro Pe"];
        [fulanito setEdad: 21];
        [fulanito saludar];
        [fulanito init];
        [fulanito saludar];
        [fulanito initWithNombre:@"Elías"];
        [fulanito saludar];
        fulanito = NULL;
        NSLog(@"%@", fulanito); // La instancia se pierde por lo tanto los datos y la dirección de memoria igual
        
    }
    return 0;
}
