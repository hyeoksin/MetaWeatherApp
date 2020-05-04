package com.khs.weatherapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khs.weatherapp.model.MetaWeather

/**
 *
 *@auther hyeoksin
 *@since
 */

class MainViewModel :AndroidViewModel{

    private var liveList = MutableLiveData<List<MetaWeather>>()

    constructor(application: Application):super(application){

    }

    fun addItem(item:MetaWeather){
        var list:MutableList<MetaWeather> = mutableListOf()
        if(liveList.value != null)
            list = (liveList.value as MutableList<MetaWeather>).toMutableList()
        list.add(item)
        liveList.value = list
    }

    fun getItem():MutableLiveData<List<MetaWeather>>{
        return liveList
    }
}