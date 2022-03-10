package xyz.teamgravity.firebasecloudmessaging.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.teamgravity.firebasecloudmessaging.data.repository.FirebaseCloudMessagingRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: FirebaseCloudMessagingRepository
) : ViewModel() {

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

    }
}