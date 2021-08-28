package com.example.restapiproject.ui.networkCountries

import com.example.restapiproject.model.Model
import com.example.restapiproject.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper(private val apiClient: Retrofit) {

    fun getClasses(listener: NetworkListener) {
        val call: Call<Model> = apiClient.create(ApiInterface::class.java).getClasses()
        call.enqueue(object : Callback<Model> {

            override fun onResponse(call: Call<Model>?, response: Response<Model>?) {
                listener.onCountriesResultResponses(response?.body()!!)
            }

            override fun onFailure(call: Call<Model>?, t: Throwable?) {
                listener.onCountriesResultFailure(t?.localizedMessage)
            }

        })
    }
}