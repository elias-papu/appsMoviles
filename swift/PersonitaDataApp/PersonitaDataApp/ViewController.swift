//
//  ViewController.swift
//  PersonitaDataApp
//
//  Created by Elías Jiménez on 30/09/24.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var nombre: UITextField!
    @IBOutlet weak var textInfo: UITextView!
    var coreData: CoreDataManager = CoreDataManager()
    override func viewDidLoad() {
        super.viewDidLoad()
        textInfo.text = ""
    }
    @IBAction func btnGuarda(_ sender: Any) {
        let name:String = nombre.text ?? ""
        if !name.isEmpty {
            coreData.guardarPersonita(nombre: name)
            nombre.text = ""
        }
        else {
            print("El nombre no debe estar vacío Pedro!")
        }
    }
    @IBAction func mostrar(_ sender: Any) {
        var personitas = coreData.leerPersonitas()
        textInfo.text = ""
        for personita in personitas {
            textInfo.text.append((personita.nombre ?? "") + "\n")
        }
    }
}

