package com.khs.weatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khs.weatherapp.R
import com.khs.weatherapp.databinding.MainBinder
import com.khs.weatherapp.model.MetaWeather
import com.khs.weatherapp.service.GetWeatherDataService
import com.khs.weatherapp.service.RetrofitInstance
import com.khs.weatherapp.view.adapter.WeatherAdapter
import com.khs.weatherapp.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var cityList:HashMap<Int,Int> = hashMapOf()
    private lateinit var binding:MainBinder
    private lateinit var viewModel:MainViewModel
    private lateinit var service:GetWeatherDataService
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBinding()
        init()
        setRecyclerView()
        observeViewModel()
        getWeather(0)
    }

    private fun observeViewModel() {
        viewModel.getItem().observe(this,Observer{ list->
            adapter.submitList(list)
        })
    }

    private fun setBinding(){
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
    }

    private fun init(){
        cityList.put(0,1132599)     // 서울
        cityList.put(1,44418)       // 런던
        cityList.put(2,2379574)     // 시카고
        service = RetrofitInstance.getService()!!
    }

    private fun setRecyclerView(){
        adapter = WeatherAdapter(this)
        recyclerView = binding.rvWeatherList
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }

    fun getWeather(rc_count:Int){
        if(rc_count<cityList.size) {
            val call = service.getWeatherInfoOfLocationOfDay(cityList[rc_count])
            call?.enqueue(object : Callback<MetaWeather> {
                override fun onFailure(call: Call<MetaWeather>, t: Throwable) {
                    if (rc_count <= cityList.size - 1) {
                        getWeather(rc_count + 1)
                        Log.d("DEBUG", "FAIL - RC_COUNT: "+rc_count)
                    }
                }
                override fun onResponse(call: Call<MetaWeather>, response: Response<MetaWeather>) {
                    val weather = response.body()
                    if (weather != null && weather.consolidatedWeather != null) {
                        viewModel.addItem(weather)
                        getWeather(rc_count + 1)
                    }
                }
            })
        }
    }
}
