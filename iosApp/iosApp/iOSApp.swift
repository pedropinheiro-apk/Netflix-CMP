import SwiftUI
import streamplayerapp
import FirebaseCore

@main
struct iOSApp: App {
    
    init() {
        KoinIosHelper().doInitKoin(lottieViewProvider: LottieViewProviderImpl())
        FirebaseApp.configure()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
