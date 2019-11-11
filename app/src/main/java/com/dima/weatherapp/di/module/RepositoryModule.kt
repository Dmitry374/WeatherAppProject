package com.dima.weatherapp.di.module

import com.dima.weatherapp.data.internaldata.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideInternalRepo(): Repository {
        return Repository()
    }

}