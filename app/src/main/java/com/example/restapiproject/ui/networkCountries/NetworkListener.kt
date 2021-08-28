package com.example.restapiproject.ui.networkCountries

import com.example.restapiproject.model.ResultItem

interface NetworkListener {
    fun onCountriesResultResponses(models: MutableList<ResultItem>?)
    fun onCountriesResultFailure(message: String?)
}