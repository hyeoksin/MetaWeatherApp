package com.khs.weatherapp.service

import com.khs.weatherapp.model.MetaWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetWeatherDataService{
    @GET("/api/location/{woeid}/")
    fun getWeatherInfoOfLocationOfDay(@Path("woeid") location:Int?): Call<MetaWeather>
}