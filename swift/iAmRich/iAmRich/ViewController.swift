//
//  ViewController.swift
//  iAmRich
//
//  Created by Elías Jiménez on 02/09/24.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imagen: UIImageView!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        imagen.image = UIImage(named: "imrich")
    }


}

