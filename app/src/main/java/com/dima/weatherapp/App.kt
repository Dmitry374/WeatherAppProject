package com.dima.weatherapp

import android.app.Application
import com.dima.weatherapp.di.component.AppComponent
import com.dima.weatherapp.di.component.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        instance = this

        appComponent = DaggerAppComponent.builder()
            .build()

        appComponent.inject(this)
    }

    fun getAppComponent() : AppComponent {
        return appComponent
    }

    companion object {
        lateinit var instance: App private set
    }
}