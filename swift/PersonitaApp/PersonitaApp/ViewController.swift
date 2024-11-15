//
//  ViewController.swift
//  PersonitaApp
//
//  Created by Elías Jiménez on 26/08/24.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var textNombre: UITextField!
    @IBOutlet weak var edad: UIDatePicker!
    @IBOutlet weak var labelDatos: UILabel!
    
    var miPersona: Personita = Personita(nombre: "Fulano", edad: 0)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        labelDatos.text = ""
    }
    
    @IBAction func fecha(_ sender: Any) {
    }
    @IBAction func guardar(_ sender: Any) {
        miPersona.nombre = textNombre.text ?? ""
        miPersona.edad = obtenerFecha()
        labelDatos.text = miPersona.imprimir()
    }
    @IBAction func crecer(_ sender: Any) {
        miPersona.crecer()
        labelDatos.text = miPersona.imprimir()
    }
    
    func obtenerFecha() -> Int {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy" // O el formato que necesites
        let yearString = dateFormatter.string(from: edad.date)
        let fecha = dateFormatter.string(from: Date())
        
        return (Int(fecha) ?? 0 ) - (Int(yearString) ?? 0)
    }

}

