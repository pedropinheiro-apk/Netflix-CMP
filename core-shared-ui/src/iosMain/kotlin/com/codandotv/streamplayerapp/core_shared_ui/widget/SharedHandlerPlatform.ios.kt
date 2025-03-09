package com.codandotv.streamplayerapp.core_shared_ui.widget
import platform.Foundation.NSURL
import platform.UIKit.UIApplication
import platform.UIKit.UIPasteboard

actual class SharedHandlerPlatform {

    actual fun shareWhatsApp(title: String, url: String) {
        openUrl("whatsapp://send?text=$title - $url")
    }

    actual fun shareSms(title: String, url: String) {
        openUrl("sms:?&body=$title - $url")
    }

    actual fun shareInstagram(url: String) {
        openUrl("instagram://app")
    }

    actual fun copyToClipboard(url: String) {
        UIPasteboard.generalPasteboard.string = url
    }

    actual fun shareMoreOptions(title: String, url: String) {
        openUrl("mailto:?subject=$title&body=$url")
    }

    private fun openUrl(url: String) {
        val nsUrl = NSURL.URLWithString(url)
        if (nsUrl != null && UIApplication.sharedApplication.canOpenURL(nsUrl)) {
            UIApplication.sharedApplication.openURL(nsUrl)
        }
    }
}

actual fun getSharedHandlerPlatform(): SharedHandlerPlatform = SharedHandlerPlatform()