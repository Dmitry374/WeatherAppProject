package com.dima.weatherapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

object Model {

    @Parcelize
    data class WeatherCity(var cnt: Int, var list: kotlin.collections.List<List>) : Parcelable

    @Parcelize
    data class List(var coord: Coord, var sys: Sys, var weather: kotlin.collections.List<Weather>,
                    var main: Main, var visibility: Int, var wind: Wind, var clouds: Clouds,
                    var dt: Int, var id: Int, var name: String) : Parcelable

    @Parcelize
    data class Coord(var lon: Double, var lat: Double) : Parcelable

    @Parcelize
    data class Sys(var type: Int, var id: Int, var message: Double, var country: String,
                   var sunrise: Int, var sunset: Int) : Parcelable

    @Parcelize
    data class Weather(var id: Int, var main: String, var description: String, var icon: String) : Parcelable

    @Parcelize
    data class Wind(var speed: Double, var deg: Int) : Parcelable

    @Parcelize
    data class Main(var temp: Double, var pressure: Int, var humidity: Int, var temp_min: Int,
                    var temp_max: Int) : Parcelable

    @Parcelize
    data class Clouds(var all: Int) : Parcelable

}