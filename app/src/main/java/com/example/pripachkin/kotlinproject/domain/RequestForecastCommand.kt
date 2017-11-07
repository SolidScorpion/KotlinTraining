package com.example.pripachkin.kotlinproject.domain

import com.example.pripachkin.kotlinproject.data.ForecastRequest

/**
 * Created by Anton P. on 07.11.2017.
 */
class RequestForecastCommand (private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}