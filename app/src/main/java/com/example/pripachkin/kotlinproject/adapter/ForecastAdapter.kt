package com.example.pripachkin.kotlinproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.pripachkin.kotlinproject.domain.ForecastList

/**
 * Created by Pripachkin on 06.11.2017.
 */
class ForecastAdapter (val data : ForecastList) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(data.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(val textView:TextView) : RecyclerView.ViewHolder(textView)
}