package com.example.pripachkin.kotlinproject.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.pripachkin.kotlinproject.R
import com.example.pripachkin.kotlinproject.adapter.ForecastAdapter
import com.example.pripachkin.kotlinproject.domain.Forecast
import com.example.pripachkin.kotlinproject.domain.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = find<RecyclerView>(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastAdapter(result,
                        object : ForecastAdapter.OnItemClickListener {
                            override fun invoke(foreacast: Forecast) {
                                toast(foreacast.date)
                            }
                        })
            }
        }
    }
}

