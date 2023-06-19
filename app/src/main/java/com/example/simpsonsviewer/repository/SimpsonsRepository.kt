package com.example.simpsonsviewer.repository

import com.example.simpsonsviewer.service.RetrofitService

class SimpsonsRepository constructor(private val retrofitService: RetrofitService) {

    fun getSimpsonsData() = retrofitService.getSimpsonsData("simpsons+characters", "json")

    fun getWireData() = retrofitService.getSimpsonsData("the+wire+characters", "json")
}