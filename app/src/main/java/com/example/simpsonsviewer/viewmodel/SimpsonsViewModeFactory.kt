package com.example.simpsonsviewer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simpsonsviewer.repository.SimpsonsRepository

class SimpsonsViewModeFactory constructor(private val repository: SimpsonsRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SimpsonsViewModel::class.java)) {
            SimpsonsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}