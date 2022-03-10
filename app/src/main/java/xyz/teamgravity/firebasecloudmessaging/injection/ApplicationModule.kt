package xyz.teamgravity.firebasecloudmessaging.injection

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.teamgravity.firebasecloudmessaging.core.extension.Preferences
import xyz.teamgravity.firebasecloudmessaging.data.remote.FirebaseCloudMessagingApi
import xyz.teamgravity.firebasecloudmessaging.data.repository.FirebaseCloudMessagingRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideFirebaseCloudMessagingApi(factory: GsonConverterFactory): FirebaseCloudMessagingApi =
        Retrofit.Builder()
            .baseUrl(FirebaseCloudMessagingApi.BASE_URL)
            .addConverterFactory(factory)
            .build()
            .create(FirebaseCloudMessagingApi::class.java)

    @Provides
    @Singleton
    fun provideFirebaseCloudMessagingRepository(api: FirebaseCloudMessagingApi): FirebaseCloudMessagingRepository =
        FirebaseCloudMessagingRepository(api)

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences = app.getSharedPreferences(Preferences.PREFS, Context.MODE_PRIVATE)
}