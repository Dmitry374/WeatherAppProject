package com.dima.weatherapp.di.component

import com.dima.weatherapp.App
import com.dima.weatherapp.di.module.ActivityModule
import com.dima.weatherapp.di.module.AppModule
import com.dima.weatherapp.di.module.FragmentModule
import com.dima.weatherapp.di.module.RepositoryModule
import com.dima.weatherapp.ui.detail.DetailFragment
import com.dima.weatherapp.ui.list.WeatherListFragment
import com.dima.weatherapp.ui.main.MainActivity
import com.dima.weatherapp.ui.tabs.TabsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityModule::class, FragmentModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(application: App)

    fun inject(mainActivity: MainActivity)

    fun inject(tabsFragment: TabsFragment)

    fun inject(weatherListFragment: WeatherListFragment)

    fun inject(detailFragment: DetailFragment)

}