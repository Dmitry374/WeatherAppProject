package com.dima.weatherapp.data.repositories

import com.dima.weatherapp.data.model.Model

interface InternalDataRepository {

    fun saveWeatherCity(weatherCity: Model.WeatherCity)
    fun getWeatherCity(): Model.WeatherCity

}