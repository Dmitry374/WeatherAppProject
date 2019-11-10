package com.dima.weatherapp.ui.main

import com.dima.weatherapp.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {

    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {

    }

}