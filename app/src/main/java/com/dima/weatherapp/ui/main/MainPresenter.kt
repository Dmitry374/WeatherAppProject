package com.dima.weatherapp.ui.main

import com.dima.weatherapp.api.RemoteRepositoryImpl
import com.dima.weatherapp.data.internaldata.Repository
import com.dima.weatherapp.data.model.Model
import com.dima.weatherapp.util.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(private val repository: Repository) : MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val storeRepository = RemoteRepositoryImpl()
    private lateinit var view: MainContract.View

    private val map = mutableMapOf<String, String>()

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

        val subscribe = storeRepository.getCityWeatherList(map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ weatherCity: Model.WeatherCity? ->
                if (weatherCity != null) {
                    repository.saveWeatherCity(weatherCity)
                }
            }, { error ->
                error.printStackTrace()
            })

        subscriptions.add(subscribe)
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }
}