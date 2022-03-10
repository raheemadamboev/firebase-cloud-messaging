package xyz.teamgravity.firebasecloudmessaging.data.repository

import okhttp3.ResponseBody
import retrofit2.Response
import xyz.teamgravity.firebasecloudmessaging.data.model.NotificationModel
import xyz.teamgravity.firebasecloudmessaging.data.remote.FirebaseCloudMessagingApi

class FirebaseCloudMessagingRepository(
    private val api: FirebaseCloudMessagingApi
) {

    suspend fun postNotification(notification: NotificationModel): Response<ResponseBody> {
        return api.postNotification(notification)
    }
}