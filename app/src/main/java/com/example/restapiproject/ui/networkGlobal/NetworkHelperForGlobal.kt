package com.example.restapiproject.ui.networkGlobal

import com.example.restapiproject.model.GlobalResult
import com.example.restapiproject.retrofit.ApiInterface
import com.example.restapiproject.ui.networkCountries.NetworkListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelperForGlobal(private val apiClient: Retrofit) {

    fun getGlobalResult(listener: NetworkListenerForGlobal) {
        val call: Call<GlobalResult> =
            apiClient.create(ApiInterface::class.java).getGlobalResult()
        call.enqueue(object : Callback<GlobalResult> {

            override fun onResponse(
                call: Call<GlobalResult>?,
                response: Response<GlobalResult>?
            ) {
                listener.onGlobalResultResponses(response?.body()!!)
            }

            override fun onFailure(call: Call<GlobalResult>?, t: Throwable?) {
                listener.onGlobalResultFailure(t?.localizedMessage)
            }
        })

    }
}