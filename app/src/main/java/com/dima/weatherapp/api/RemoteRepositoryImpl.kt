package com.dima.weatherapp.api

import com.dima.weatherapp.data.model.Model
import com.dima.weatherapp.data.repositories.RemoteRepository
import io.reactivex.Observable

class RemoteRepositoryImpl : RemoteRepository {

    override fun getCityWeatherList(params: Map<String, String>): Observable<Model.WeatherCity> {
        return ApiServiceInterface.create().getCityWeatherList(params)
    }
}