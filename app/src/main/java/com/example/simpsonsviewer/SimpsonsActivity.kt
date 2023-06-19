package com.example.simpsonsviewer

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpsonsviewer.adapter.SimpsonsCustomAdapter
import com.example.simpsonsviewer.adapter.SimpsonsTextClickListener
import com.example.simpsonsviewer.data.RelatedTopics
import com.example.simpsonsviewer.databinding.ActivitySimpsonsBinding
import com.example.simpsonsviewer.repository.SimpsonsRepository
import com.example.simpsonsviewer.service.RetrofitService
import com.example.simpsonsviewer.viewmodel.SimpsonsViewModeFactory
import com.example.simpsonsviewer.viewmodel.SimpsonsViewModel
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class SimpsonsActivity : AppCompatActivity(), SimpsonsTextClickListener {

    private lateinit var binding: ActivitySimpsonsBinding

    lateinit var viewModel: SimpsonsViewModel

    private val retrofitService = RetrofitService.getInstance()

    private lateinit var customAdapter: SimpsonsCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpsonsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            SimpsonsViewModeFactory(SimpsonsRepository(retrofitService))
        )[SimpsonsViewModel::class.java]

        viewModel.getSimpsonsData()

        viewModel.simpsonsResponse.observe(this, Observer {
            customAdapter = SimpsonsCustomAdapter(it.RelatedTopics, this)
            val layoutManager = LinearLayoutManager(applicationContext)
            binding.simpsonsListView.layoutManager = layoutManager
            binding.simpsonsListView.adapter = customAdapter
        })

    }

    override fun onSimpsonsTextClickListener(relatedTopics: RelatedTopics) {
        showDialog(relatedTopics)
    }

    private fun showDialog(relatedTopics: RelatedTopics) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.simpson_detail_view)
        val text = dialog.findViewById<TextView>(R.id.tvIconText)
        text.text = relatedTopics.Text
        val description = dialog.findViewById<TextView>(R.id.tvIconDescription)
        description.text = relatedTopics.Result
        val imageView = dialog.findViewById<ImageView>(R.id.ivIcon)
        Picasso.get()
            .load(relatedTopics.Icon.url)
            .resize(300, 300)
            .into(imageView)
        dialog.show()

    }
}