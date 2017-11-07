package com.example.pripachkin.kotlinproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.pripachkin.kotlinproject.R
import com.example.pripachkin.kotlinproject.domain.Forecast
import com.example.pripachkin.kotlinproject.domain.ForecastList
import com.example.pripachkin.kotlinproject.ui.utils.ctx
import com.squareup.picasso.Picasso

/**
 * Created by Pripachkin on 06.11.2017.
 */
class ForecastAdapter(val data: ForecastList, val itemClickListener: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(inflate, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(data[position])
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(val view: View, val itemClick: (Forecast) -> Unit)
        : RecyclerView.ViewHolder(view) {
        private val iconView = view.findViewById<ImageView>(R.id.icon)
        private val dateView = view.findViewById<TextView>(R.id.date)
        private val descriptionView = view.findViewById<TextView>(R.id.description)
        private val maxTemp = view.findViewById<TextView>(R.id.maxTemperature)
        private val minTemp = view.findViewById<TextView>(R.id.minTemperature)
        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(view.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemp.text = "$high"
                minTemp.text = "$low"
                view.setOnClickListener { itemClick(this) }
            }
        }

    }

    interface OnItemClickListener {
        operator fun invoke(foreacast: Forecast)
    }
}