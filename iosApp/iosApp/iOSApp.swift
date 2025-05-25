import SwiftUI
import streamplayerapp
import FirebaseCore

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
    init() {
        KoinIosHelper().doInitKoin(lottieViewProvider: LottieViewProviderImpl())
        FirebaseApp.configure()

        SyncBridge.shared.syncData {
            print("BG Testes Data sync completed")
        }
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
