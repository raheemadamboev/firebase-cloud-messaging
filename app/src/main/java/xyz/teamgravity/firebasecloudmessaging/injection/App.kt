package xyz.teamgravity.firebasecloudmessaging.injection

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import dagger.hilt.android.HiltAndroidApp
import xyz.teamgravity.firebasecloudmessaging.core.constant.Notification

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                Notification.NOTIFICATION_CHANNEL_ID,
                Notification.NOTIFICATION_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Just to send notification, you know!"
                enableLights(true)
                lightColor = Color.RED
            }
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }
    }
}