package com.example.restapiproject.retrofit


import com.example.restapiproject.model.GlobalResult
import com.example.restapiproject.model.Model
import com.example.restapiproject.model.ResultItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface{
    @GET("/countries")
    fun getClasses() : Call<Model>

    @GET("/all")
    fun getGlobalResult() : Call<GlobalResult>

    @GET("/countries")
    fun searchCountries(type: Int, word: String) : Call<ResultItem>
}