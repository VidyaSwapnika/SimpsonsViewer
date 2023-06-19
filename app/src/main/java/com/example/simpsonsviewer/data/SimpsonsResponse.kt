package com.example.simpsonsviewer.data

import com.google.gson.annotations.SerializedName

data class SimpsonsResponse(@SerializedName("Abstract") val abstract : String, @SerializedName("AbstractSource") val abstractSource : String, val RelatedTopics : ArrayList<RelatedTopics>)