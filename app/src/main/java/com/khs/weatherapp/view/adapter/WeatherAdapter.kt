package com.khs.weatherapp.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.khs.weatherapp.R
import com.khs.weatherapp.databinding.WeatherBinder
import com.khs.weatherapp.model.MetaWeather
import com.khs.weatherapp.view.adapter.callback.WeatherDiffCallback
import com.khs.weatherapp.view.holder.WeatherViewHolder
import java.util.*

class WeatherAdapter(
    val context: Context
):ListAdapter<MetaWeather,WeatherViewHolder>(WeatherDiffCallback()) {

    private lateinit var weatherBinder: WeatherBinder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        weatherBinder = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_weather,
            parent,
            false
        )
        return WeatherViewHolder(context, weatherBinder)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = getItem(position)
        weather?.let {
            weatherBinder.metaWeather = weather
        }
    }

}
