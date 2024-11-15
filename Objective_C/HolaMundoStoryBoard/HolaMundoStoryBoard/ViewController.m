//
//  ViewController.m
//  HolaMundoStoryBoard
//
//  Created by Elías Jiménez on 26/08/24.
//

#import "ViewController.h"

@interface ViewController ()
@property (weak, nonatomic) IBOutlet UITextField *textNombre; //esto se creó seleccionando el input, apretando ctrl y arrastrando abajo de interface, un outlet hace un puente entre la interfaz visual y el código, esto crea el _textNombre, setNombre y el getter
@property (weak, nonatomic) IBOutlet UILabel *textSaludo; //Se hizo lo mismo pero con el label de saludo

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];//agarro un metodo del padre y se lo heredo al hijo, se llama polimorfismo
    // Do any additional setup after loading the view.
    [_textSaludo setText: @""]; //Inicializando saludo en cadena vacía
    
}
- (IBAction)botonSaludar:(id)sender { //Esto se creó haciendo lo mismo de arriba, pero con el botón, esto es un método
    NSString *nombre = [_textNombre text]; //agarramos el texto del input y lo guardamos en la variable de nombre
    
    [_textSaludo setText: [NSString stringWithFormat: @"Hola %@ cómo estás?", nombre]];
    
}


@end
