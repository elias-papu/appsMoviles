//
//  ViewController.swift
//  persona
//
//  Created by Elías Jiménez on 29/08/24.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var nombre: UITextField!
    @IBOutlet weak var info: UITextView!
    @IBOutlet weak var edad: UIDatePicker!
    @IBOutlet weak var apPat: UITextField!
    @IBOutlet weak var apMat: UITextField!
    @IBOutlet weak var email: UITextField!
    @IBOutlet weak var tel: UITextField!
    
    var miPersona: Personota = Personota(nombre: "", apPat: "", apMat: "", mail: "", tel: "",edad: 0)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        info.text = ""
    }
    @IBAction func fecha(_ sender: Any) {
        
    }
    @IBAction func botonAceptar(_ sender: Any) {
        miPersona.nombre = nombre.text ?? ""
        miPersona.apPat = apPat.text ?? ""
        miPersona.apMat = apMat.text ?? ""
        miPersona.mail = email.text ?? ""
        miPersona.tel = tel.text ?? ""
        miPersona.edad = obtenerFecha()
        info.text = miPersona.imprimir()
    }
    func obtenerFecha() -> Int {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy" // O el formato que necesites
        let yearString = dateFormatter.string(from: edad.date)
        let fecha = dateFormatter.string(from: Date())
        
        return (Int(fecha) ?? 0 ) - (Int(yearString) ?? 0)
    }
}

