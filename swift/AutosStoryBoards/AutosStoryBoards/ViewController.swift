//
//  ViewController.swift
//  AutosStoryBoards
//
//  Created by Elías Jiménez on 02/09/24.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var marca: UITextField!
    @IBOutlet weak var modelo: UITextField!
    @IBOutlet weak var imprimir: UITextView!
    var miAuto: Auto = Auto()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        imprimir.text = ""
    }
    
    func validar() -> Bool {
        if(marca.text == "" || modelo.text == "") {
            return false
        }
        return true
    }
    @IBAction func avanzar(_ sender: Any) {
        miAuto.avanzar(x: 10)
        imprimir.text = miAuto.imprimir()
    }
    
    @IBAction func guardar(_ sender: Any) {
        if validar() {
            miAuto.marca = marca.text ?? ""
            miAuto.modelo = modelo.text ?? ""
            
            imprimir.text = miAuto.imprimir()
        }
        else {
            imprimir.text = "Los campos están vacios"
        }
    }
}
