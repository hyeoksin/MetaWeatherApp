package com.khs.weatherapp.view.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.khs.weatherapp.model.MetaWeather
import java.text.FieldPosition


abstract class BaseViewHolder: RecyclerView.ViewHolder{
    private var context:Context
    constructor(context: Context,view: View):super(view){
        this.context = context
    }
    abstract fun bindDataToViewHolder(item:MetaWeather?,position:Int)
}
