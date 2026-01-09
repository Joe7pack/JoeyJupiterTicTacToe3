//
//  JoeyJupiterTicTacToe3App.swift
//  JoeyJupiterTicTacToe3
//
//  Created by Joe Guzzardo on 1/4/26.
//

import SwiftUI
import CoreData

@main
struct JoeyJupiterTicTacToe3App: App {
    let persistenceController = PersistenceController.shared

    var body: some Scene {
        WindowGroup {
            ContentView()
                .environment(\.managedObjectContext, persistenceController.container.viewContext)
        }
    }
}
