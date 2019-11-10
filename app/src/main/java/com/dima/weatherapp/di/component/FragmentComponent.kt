package com.dima.weatherapp.di.component

import com.dima.weatherapp.di.module.FragmentModule
import com.dima.weatherapp.ui.list.ListFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(listFragment: ListFragment)

}