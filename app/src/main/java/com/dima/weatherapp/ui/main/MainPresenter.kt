package com.dima.weatherapp.ui.main

import com.dima.weatherapp.api.ApiServiceInterface
import com.dima.weatherapp.model.Model
import com.dima.weatherapp.util.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter : MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: MainContract.View

    val map = mutableMapOf<String, String>()

    override fun subscribe() {

    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showListFragment() // as default
    }

    override fun loadData(ids: String) {

        map["id"] = ids
        map["units"] = "metric"
        map["appid"] = Constants.API_KEY

        val subscribe = api.getCityWeatherList(map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ weatherCity: Model.WeatherCity? ->
                println(weatherCity)
            }, { error ->
                error.printStackTrace()
            })

        subscriptions.add(subscribe)
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }
}