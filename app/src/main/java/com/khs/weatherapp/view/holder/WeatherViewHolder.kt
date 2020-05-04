package com.khs.weatherapp.view.holder

import android.content.Context
import com.khs.weatherapp.databinding.WeatherBinder
import com.khs.weatherapp.model.MetaWeather
import com.khs.weatherapp.model.Weather


class WeatherViewHolder:BaseViewHolder{

    private lateinit var weatherBinder: WeatherBinder
    constructor(context: Context,weatherBinder: WeatherBinder):super(context,weatherBinder.root){
        this.weatherBinder = weatherBinder
    }

    override fun bindDataToViewHolder(item: MetaWeather?, position: Int) {}
}
