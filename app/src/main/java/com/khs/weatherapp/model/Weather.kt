package com.khs.weatherapp.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Weather(
    val air_pressure: Double,                // 기압
    val applicable_date: String,            // 적용날짜
    val created: Date,                       // 날씨 정보 생성 일자
    val humidity: Double,                    // 습도(%)
    val id: Long,                            // 인덱스
    val max_temp: Double,                    // 최고 기온
    val min_temp: Double,                   // 최저 기온
    val predictability: Int,                 // 확률(%)
    val the_temp: Double,                     // 평균 기온
    val visibility: Double,                   // (miles)
    val weather_state_abbr: String,          // 날씨 약어
    val weather_state_name: String,          // 날씨 이름
    val wind_direction: Double,               // 풍향
    val wind_direction_compass: String,      // 바람 방향의 나침반
    val wind_speed: Double                    // 풍속
){
    val readableMaxTemp:String
        get() = String.format("%.2f",max_temp)
    val readableMinTemp:String
        get() = String.format("%.2f",min_temp)
}