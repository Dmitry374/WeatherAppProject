package com.dima.weatherapp.di.module

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

}