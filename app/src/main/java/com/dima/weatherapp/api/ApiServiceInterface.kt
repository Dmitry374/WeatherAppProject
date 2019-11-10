package com.dima.weatherapp.api

import com.dima.weatherapp.BuildConfig
import com.dima.weatherapp.model.Model
import com.dima.weatherapp.util.Constants.Companion.BASE_URL
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiServiceInterface {

    @GET("data/2.5/group")
    fun getCityWeatherList(@QueryMap params: Map<String, String>): Observable<Model.WeatherCity>

    companion object Factory {

        fun create(): ApiServiceInterface {

            val okHttpBuilder = OkHttpClient.Builder()

            //init logging interceptor
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            } else {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
            }

            okHttpBuilder.addInterceptor(httpLoggingInterceptor)

            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}