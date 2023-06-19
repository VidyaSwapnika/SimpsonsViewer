package com.example.simpsonsviewer.service

import com.example.simpsonsviewer.data.SimpsonsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("/")
    fun getSimpsonsData(@Query("q", encoded=true) q: String, @Query("format") format: String): Call<SimpsonsResponse>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://api.duckduckgo.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}