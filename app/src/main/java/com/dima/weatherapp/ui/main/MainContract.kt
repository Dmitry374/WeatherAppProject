package com.dima.weatherapp.ui.main

import androidx.fragment.app.Fragment
import com.dima.weatherapp.data.model.Model
import com.dima.weatherapp.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showListFragment()
        fun replaceFragment(fragment: Fragment, tag: String)
        fun showList(weatherCity: Model.WeatherCity)
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {
        fun loadData(ids: String)
    }

}