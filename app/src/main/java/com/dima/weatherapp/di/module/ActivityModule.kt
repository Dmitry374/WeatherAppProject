package com.dima.weatherapp.di.module

import com.dima.weatherapp.data.internaldata.Repository
import com.dima.weatherapp.ui.main.MainContract
import com.dima.weatherapp.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun providePresenter(repository: Repository): MainContract.Presenter {
        return MainPresenter(repository)
    }

}