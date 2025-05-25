package com.codandotv.streamplayerapp


import com.mmk.kmpnotifier.notification.NotificationImage
import com.mmk.kmpnotifier.notification.Notifier
import com.mmk.kmpnotifier.notification.NotifierManager
import kotlin.random.Random

object NotifierHelper {
    fun showSimpleNotification(
        title: String = "Notificação Simples",
        body: String = "Corpo da Notificação Simples",
    ) {
        val notifier = NotifierManager.getLocalNotifier()
        notifier.notify {
            id= Random.nextInt(0, Int.MAX_VALUE)
            this.title = title
            this.body = body
            payloadData = mapOf(
                Notifier.KEY_URL to "https://github.com/mirzemehdi/KMPNotifier/",
                "extraKey" to "randomValue"
            )
        }
    }


    fun showTestNotificationRegister() {
        val notifier = NotifierManager.getLocalNotifier()
        notifier.notify {
            id= Random.nextInt(0, Int.MAX_VALUE)
            title = "Task disparada"
            body = "Corpo da task disparada Body message from KMPNotifier"
            payloadData = mapOf(
                Notifier.KEY_URL to "https://github.com/mirzemehdi/KMPNotifier/",
                "extraKey" to "randomValue"
            )
            image = NotificationImage.Url("https://github.com/user-attachments/assets/a0f38159-b31d-4a47-97a7-cc230e15d30b")
        }
    }
}