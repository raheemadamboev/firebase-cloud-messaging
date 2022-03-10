package xyz.teamgravity.firebasecloudmessaging.data.remote

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import xyz.teamgravity.firebasecloudmessaging.data.model.NotificationModel

interface FirebaseCloudMessagingApi {

    companion object {
        const val BASE_URL = "https://fcm.googleapis.com"
        private const val CONTENT_TYPE = "application/json"
    }

    @POST("fcm/send")
    @Headers("Authorization: key=${FirebaseCloudMessagingKey.VALUE}", "Content-Type:$CONTENT_TYPE")
    suspend fun postNotification(
        @Body notification: NotificationModel
    ): Response<ResponseBody>
}