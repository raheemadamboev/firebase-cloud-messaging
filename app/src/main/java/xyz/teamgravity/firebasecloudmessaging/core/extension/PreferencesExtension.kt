package xyz.teamgravity.firebasecloudmessaging.core.extension

import android.content.SharedPreferences

object Preferences {

    /**
     * SharedPreferences for the whole app
     */
    const val PREFS = "firebaseCloudMessagingPrefs"

    /**
     * Firebase Cloud Messaging Token -> String
     */
    const val TOKEN = "token"
    const val DEFAULT_TOKEN = ""
}

fun SharedPreferences.token() = getString(Preferences.TOKEN, Preferences.DEFAULT_TOKEN) ?: Preferences.DEFAULT_TOKEN