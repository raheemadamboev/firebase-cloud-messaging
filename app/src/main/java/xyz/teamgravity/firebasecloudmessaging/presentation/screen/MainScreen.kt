package xyz.teamgravity.firebasecloudmessaging.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.teamgravity.firebasecloudmessaging.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen() {
    val viewmodel = hiltViewModel<MainViewModel>()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = viewmodel.title,
            onValueChange = viewmodel::onTitleChange,
            placeholder = {
                Text(text = "Title")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = viewmodel.message,
            onValueChange = viewmodel::onMessageChange,
            placeholder = {
                Text(text = "Message")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = viewmodel.token,
            onValueChange = viewmodel::onTokenChange,
            placeholder = {
                Text(text = "Token")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = viewmodel::onSendNotification) {
            Text(text = "Send notification")
        }
    }
}