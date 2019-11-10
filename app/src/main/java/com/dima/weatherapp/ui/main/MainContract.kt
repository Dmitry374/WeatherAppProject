package com.dima.weatherapp.ui.main

import com.dima.weatherapp.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showListFragment()
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {

    }

}