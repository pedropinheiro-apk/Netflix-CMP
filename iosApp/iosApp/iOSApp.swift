import SwiftUI
import streamplayerapp

@main
struct iOSApp: App {
    
    init() {
        KoinIosHelper().doInitKoin(LottieViewProviderImpl())
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
