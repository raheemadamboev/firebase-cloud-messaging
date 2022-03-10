package xyz.teamgravity.firebasecloudmessaging.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException
import xyz.teamgravity.firebasecloudmessaging.core.constant.Notification
import xyz.teamgravity.firebasecloudmessaging.data.model.NotificationDataModel
import xyz.teamgravity.firebasecloudmessaging.data.model.NotificationModel
import xyz.teamgravity.firebasecloudmessaging.data.repository.FirebaseCloudMessagingRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: FirebaseCloudMessagingRepository
) : ViewModel() {

    private var job: Job? = null

    var title by mutableStateOf("")
        private set

    var message by mutableStateOf("")
        private set

    var token by mutableStateOf("")
        private set

    fun onTitleChange(value: String) {
        title = value
    }

    fun onMessageChange(value: String) {
        message = value
    }

    fun onTokenChange(value: String) {
        token = value
    }

    fun onSendNotification() {
        if (title.isBlank() || message.isBlank()) return

        job?.cancel()
        job = viewModelScope.launch {
            try {
                val response = repository.postNotification(
                    NotificationModel(
                        data = NotificationDataModel(
                            title = title,
                            message = message
                        ),
                        to = token.ifBlank { Notification.TOPIC }
                    )
                )

                if (response.isSuccessful) {
                    title = ""
                    message = ""
                    token = ""

                    println("raheem: success!")
                } else {
                    println("raheem: noooo!")
                }

            } catch (e: HttpException) {
                println("raheem: ${e.message()}")
            }
        }
    }
}