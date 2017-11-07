package com.example.pripachkin.kotlinproject.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.pripachkin.kotlinproject.R
import com.example.pripachkin.kotlinproject.adapter.ForecastAdapter
import com.example.pripachkin.kotlinproject.domain.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastAdapter(result) { toast(it.date) }
            }
        }
    }
}

