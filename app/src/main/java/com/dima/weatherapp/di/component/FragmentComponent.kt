package com.dima.weatherapp.di.component

import com.dima.weatherapp.di.module.FragmentModule
import com.dima.weatherapp.ui.detail.DetailFragment
import com.dima.weatherapp.ui.list.WeatherListFragment
import com.dima.weatherapp.ui.list1.ListFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(listFragment: ListFragment)

    fun inject(weatherListFragment: WeatherListFragment)

    fun inject(detailFragment: DetailFragment)

}