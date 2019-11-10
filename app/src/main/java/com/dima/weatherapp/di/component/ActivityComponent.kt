package com.dima.weatherapp.di.component

import com.dima.weatherapp.di.module.ActivityModule
import com.dima.weatherapp.ui.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}