//
//  ContentView.swift
//  HolaSwiftUI
//
//  Created by Elías Jiménez on 18/09/24.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        HStack {
            Image(systemName: "applelogo")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Mi primer App en SwiftUI")
                .foregroundStyle(.green)
            
            Image(systemName: "applelogo")
                .imageScale(.large)
                .foregroundStyle(.red)
        }
        .padding()
        
        Text("Hola")
            .padding()
        Text("Soy")
            .padding()
        Text("Elías")
            .padding()
    }
}

#Preview {
    ContentView()
}
