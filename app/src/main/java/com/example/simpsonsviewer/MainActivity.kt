package com.example.simpsonsviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpsonsviewer.databinding.ActivityMainBinding
import com.example.simpsonsviewer.databinding.ActivityWireBinding
import com.example.wireviewer.WireActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpsons.setOnClickListener {
            val activity = Intent(this, SimpsonsActivity::class.java)
            startActivity(activity)
        }

        binding.btnWire.setOnClickListener {
            val activity = Intent(this, WireActivity::class.java)
            startActivity(activity)
        }
    }
}