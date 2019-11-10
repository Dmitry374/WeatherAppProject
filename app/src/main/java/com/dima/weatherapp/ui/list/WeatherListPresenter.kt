package com.dima.weatherapp.ui.list

class WeatherListPresenter : WeatherListContract.Presenter {

    private lateinit var view: WeatherListContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun attach(view: WeatherListContract.View) {
        this.view = view
    }
}