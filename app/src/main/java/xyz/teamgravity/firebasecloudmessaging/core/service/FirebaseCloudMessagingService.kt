package xyz.teamgravity.firebasecloudmessaging.core.service

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import xyz.teamgravity.firebasecloudmessaging.R
import xyz.teamgravity.firebasecloudmessaging.core.constant.Notification
import xyz.teamgravity.firebasecloudmessaging.core.extension.Preferences
import xyz.teamgravity.firebasecloudmessaging.presentation.activity.Main
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class FirebaseCloudMessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var shp: SharedPreferences

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        shp.edit().putString(Preferences.TOKEN, token).apply()
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        showNotification(message)
    }

    private fun showNotification(message: RemoteMessage) {
        val intent = Intent(this, Main::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        val notification = NotificationCompat.Builder(this, Notification.NOTIFICATION_CHANNEL_ID)
            .setContentTitle(message.data["title"])
            .setContentText(message.data["message"])
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(Random.nextInt(), notification)
    }
}