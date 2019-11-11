package com.dima.weatherapp.di.module

import android.content.Context
import com.dima.weatherapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }
}