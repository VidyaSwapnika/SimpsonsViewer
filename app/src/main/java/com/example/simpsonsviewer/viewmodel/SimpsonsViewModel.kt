package com.example.simpsonsviewer.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpsonsviewer.data.SimpsonsResponse
import com.example.simpsonsviewer.repository.SimpsonsRepository
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SimpsonsViewModel constructor(private val repository: SimpsonsRepository) : ViewModel() {

    val simpsonsResponse = MutableLiveData<SimpsonsResponse>()
    val errorMessage = MutableLiveData<String>()

    val wireResponse = MutableLiveData<SimpsonsResponse>()

    fun getSimpsonsData() {
        val response = repository.getSimpsonsData()
        Log.e("SIMPSONS ACTIVITY", "hello 19 19 ")

        response.enqueue( object : Callback<SimpsonsResponse> {
            override fun onResponse(
                call: Call<SimpsonsResponse>,
                response: Response<SimpsonsResponse>
            ) {
                simpsonsResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<SimpsonsResponse>, t: Throwable) {
                Log.e("SIMPSONS ACTIVITY", "hello 30 30 ${t.message}")
                errorMessage.postValue(t.message)
            }

        })
    }

    fun getWireData() {
        val response = repository.getWireData()
        response.enqueue( object : Callback<SimpsonsResponse> {
            override fun onResponse(
                call: Call<SimpsonsResponse>,
                response: Response<SimpsonsResponse>
            ) {
                simpsonsResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<SimpsonsResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}