package com.dima.weatherapp.di.module

import android.app.Activity
import com.dima.weatherapp.ui.main.MainContract
import com.dima.weatherapp.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity() : Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}