package com.khs.weatherapp.service

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 *@auther hyeoksin
 *@since
 */
class RetrofitInstance {
    companion object{
        @Volatile private var retrofit:Retrofit?=null
        private val BASE_URL = "https://www.metaweather.com/"
        fun getService():GetWeatherDataService?{
            if(retrofit==null){
                retrofit = Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(GetWeatherDataService::class.java)
        }
    }
}