//
//  main.m
//  autosObectiveC
//
//  Created by Elías Jiménez on 23/08/24.
//

#import <Foundation/Foundation.h>
#import "auto.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        Auto *miVocho;
        Auto *miAuto;
        
        miAuto = [[Auto alloc] initSinP:@"Ferrari" modelo:@"Clasico"];
        miVocho = [Auto alloc];
        
        [miVocho initSinP:@"VW" modelo:@"Sedan"];
        [miVocho mostrar];
        [miAuto mostrar];
        [miVocho moverX: 100];
        [miAuto moverX: 200];
        [miVocho mostrar];
        [miAuto mostrar];
        
    }
    return 0;
}
