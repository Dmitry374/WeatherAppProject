package com.dima.weatherapp.data.internaldata

import com.dima.weatherapp.data.model.Model
import com.dima.weatherapp.data.repositories.InternalDataRepository

class Repository : InternalDataRepository {

    private var weatherCity: Model.WeatherCity? = null

    override fun saveWeatherCity(weatherCity: Model.WeatherCity) {
        this.weatherCity = weatherCity
    }

    override fun getWeatherCity(): Model.WeatherCity {
        return this.weatherCity!!
    }
}