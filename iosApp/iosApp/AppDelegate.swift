import UIKit
import BackgroundTasks
import streamplayerapp

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]? = nil) -> Bool {

        BGTaskScheduler.shared.register(forTaskWithIdentifier: "com.codandotv.streamplayerapp", using: nil) { task in
            self.handleAppRefresh(task: task as! BGProcessingTask)
        }
        print("BGTestes Task registrada!")

        scheduleAppRefresh()
        return true
    }

    func scheduleAppRefresh() {
        let request = BGProcessingTaskRequest(identifier: "com.codandotv.streamplayerapp")
        request.requiresNetworkConnectivity = false
        request.requiresExternalPower = false
        request.earliestBeginDate = Date(timeIntervalSinceNow: 5 * 60) // 5 minutos

        do {
            try BGTaskScheduler.shared.submit(request)
            print("BGTestes tarefa agendada com sucesso para: \(request.earliestBeginDate!)")
        } catch {
            print("BGTestes falha ao agendar tarefa: \(error.localizedDescription)")
        }


    }

    func handleAppRefresh(task: BGProcessingTask) {
        print("BGTestes handleAppRefresh foi chamado!")

        scheduleAppRefresh()

        let queue = OperationQueue()
        queue.maxConcurrentOperationCount = 1

        let operation = BlockOperation {
            print("BGTestes Executando operação de sync...")
            SyncBridge.shared.syncData {
                print("BGTestes Sincronizado no IOS")
                task.setTaskCompleted(success: true)
            }
        }

        task.expirationHandler = {
            print("BGTestes Tarefa expirada.")
            queue.cancelAllOperations()
        }

        queue.addOperation(operation)
    }
}
