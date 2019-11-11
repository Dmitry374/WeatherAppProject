package com.dima.weatherapp.data.repositories

import com.dima.weatherapp.data.model.Model
import io.reactivex.Observable

interface RemoteRepository {
    fun getCityWeatherList(params: Map<String, String>): Observable<Model.WeatherCity>
}