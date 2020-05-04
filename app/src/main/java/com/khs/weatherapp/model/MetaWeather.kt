package com.khs.weatherapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class MetaWeather(
    @SerializedName("consolidated_weather")
    val consolidatedWeather: ArrayList<Weather> = arrayListOf(),
    val title: String?
)