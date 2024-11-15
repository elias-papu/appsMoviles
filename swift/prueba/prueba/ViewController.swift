//
//  ViewController.swift
//  prueba
//
//  Created by Elías Jiménez on 27/08/24.
//

import UIKit
import PDFKit

class ViewController: UIViewController {

    @IBOutlet weak var pdfView: PDFView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        guard let pdfView = pdfView else {
            print("El PDFView es nil. Verifica la conexión en el storyboard.")
            return
        }
        
        if let pdfURL = Bundle.main.url(forResource: "prac3", withExtension: "pdf") {
            let pdfDocument = PDFDocument(url: pdfURL)
            pdfView.document = pdfDocument
        } else {
            print("No se encontró el archivo PDF en el bundle.")
        }
    }
}

