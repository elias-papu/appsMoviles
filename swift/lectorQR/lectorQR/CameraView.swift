//
//  CameraView.swift
//  lectorQR
//
//  Created by Elías Jiménez on 12/10/24.
//

import SwiftUI
import AVFoundation

struct CameraView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        let controller = UIViewController()
        
        let session = AVCaptureSession()
        session.sessionPreset = .photo

        guard let videoCaptureDevice = AVCaptureDevice.default(.builtInWideAngleCamera, for: .video, position: .back) else { return controller }
        let videoInput: AVCaptureDeviceInput

        do {
            videoInput = try AVCaptureDeviceInput(device: videoCaptureDevice)
        } catch {
            return controller
        }

        if (session.canAddInput(videoInput)) {
            session.addInput(videoInput)
        } else {
            return controller
        }

        let videoLayer = AVCaptureVideoPreviewLayer(session: session)
        videoLayer.frame = controller.view.layer.bounds
        videoLayer.videoGravity = .resizeAspectFill
        controller.view.layer.addSublayer(videoLayer)

        session.startRunning()

        return controller
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        // Aquí puedes implementar actualizaciones de la UI si lo necesitas
    }
}

