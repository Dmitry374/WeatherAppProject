package com.dima.weatherapp.di.component

import com.dima.weatherapp.App
import com.dima.weatherapp.di.module.AppModule
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(application: App)

}