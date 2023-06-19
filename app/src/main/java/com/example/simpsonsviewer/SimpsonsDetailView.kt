package com.example.simpsonsviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simpsonsviewer.databinding.ActivitySimpsonsBinding
import com.example.simpsonsviewer.databinding.SimpsonDetailViewBinding

class SimpsonsDetailView : AppCompatActivity() {

    private lateinit var binding: SimpsonDetailViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SimpsonDetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}