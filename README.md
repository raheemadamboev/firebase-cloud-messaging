# firebase-cloud-messaging
Jetpack Compose app that can recieve or send push notifications over Firebase Cloud Messaging by connecting to Google APIs. There is three fields that is "Title", "Message", "Token". In order to send notification, you have to fill "Title" and "Message" field. If you also fill "Token", it only sends push notification to specific user. And, if you do not fill "Token", it sends the notification to all users using subscribed topic feature as every user are subscribed to "Raheem" topic in Application class. To send notification, in app POST request is send to Google API using Retrofit and Kotlin Coroutines. MVVM architectural component is applied.

**Firebase Cloud Messaging**

<img src="" />

<a href="https://github.com/raheemadamboev/firebase-cloud-messaging/blob/master/app-debug.apk">Download demo</a>
