//
//  main.m
//  ejemplosVideos
//
//  Created by Elías Jiménez on 27/08/24.
//

#import <Foundation/Foundation.h>

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        NSString *intString = @"1";
        
        int value1 = [intString intValue];
        NSLog(@"Value 1 is: %i", value1);
        
        NSInteger value2 = [intString integerValue];
        NSLog(@"Value 2 is: %li", (long)value2);
        
        NSString *doubleString = @"4.5";
        
        double value3 = [doubleString doubleValue];
        float value4 = [doubleString floatValue];
        
        NSLog(@"Value 3 is: %f", value3);
        NSLog(@"Value 4 is: %f", value4);
        
        int value5 = 100;
        double value6 = 23.45;
        float value7 = 546.6;
        
        NSString *string1 = [NSString stringWithFormat:@"%i", value5];
        NSString *string2 = [NSString stringWithFormat:@"%f", value6];
        NSString *string3 = [NSString stringWithFormat:@"%f", value7];
        
        NSLog(@"String 1 is %@", string1);
        NSLog(@"String 2 is %@", string2);
        NSLog(@"String 3 is %@", string3);
    }
    return 0;
}



