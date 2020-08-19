package com.dima.weatherapp.di.module

import com.dima.weatherapp.ui.detail.DetailContract
import com.dima.weatherapp.ui.detail.DetailPresenter
import com.dima.weatherapp.ui.list.WeatherListContract
import com.dima.weatherapp.ui.list.WeatherListPresenter
import com.dima.weatherapp.ui.tabs.TabsContract
import com.dima.weatherapp.ui.tabs.TabsPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideTabsPresenter(): TabsContract.Presenter {
        return TabsPresenter()
    }

    @Provides
    fun provideWeatherListPresenter(): WeatherListContract.Presenter {
        return WeatherListPresenter()
    }

    @Provides
    fun provideAboutPresenter(): DetailContract.Presenter {
        return DetailPresenter()
    }

}