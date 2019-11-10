package com.dima.weatherapp.di.module

import com.dima.weatherapp.ui.detail.DetailContract
import com.dima.weatherapp.ui.detail.DetailPresenter
import com.dima.weatherapp.ui.list.ListContract
import com.dima.weatherapp.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideAboutPresenter(): DetailContract.Presenter {
        return DetailPresenter()
    }

}