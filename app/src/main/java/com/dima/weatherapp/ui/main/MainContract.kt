package com.dima.weatherapp.ui.main

import androidx.fragment.app.Fragment
import com.dima.weatherapp.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showListFragment()
        fun replaceFragment(fragment: Fragment, tag: String)
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {
        fun loadData(ids: String)
    }

}