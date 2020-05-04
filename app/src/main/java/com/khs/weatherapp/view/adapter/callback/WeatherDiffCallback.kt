package com.khs.weatherapp.view.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import com.khs.weatherapp.model.MetaWeather

/**
 *
 *@auther hyeoksin
 *@since
 */

class WeatherDiffCallback : DiffUtil.ItemCallback<MetaWeather>(){
    override fun areItemsTheSame(oldItem: MetaWeather, newItem: MetaWeather): Boolean {
       return oldItem.title == newItem.title
    }
    override fun areContentsTheSame(oldItem: MetaWeather, newItem: MetaWeather): Boolean {
       return oldItem.consolidatedWeather[0].created == newItem.consolidatedWeather[0].created
    }
}