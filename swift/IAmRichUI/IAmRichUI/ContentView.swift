//
//  ContentView.swift
//  IAmRichUI
//
//  Created by Elías Jiménez on 22/09/24.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Text("I am rich")
            Text("I deserve it")
            Text("I am good, healty & successful")
            Image("iamrich")
                .resizable()
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
