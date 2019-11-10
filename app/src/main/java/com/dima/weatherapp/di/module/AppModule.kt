package com.dima.weatherapp.di.module

import android.app.Application
import com.dima.weatherapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApp(): Application {
        return app
    }
}