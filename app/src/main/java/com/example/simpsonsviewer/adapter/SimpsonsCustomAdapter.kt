package com.example.simpsonsviewer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.simpsonsviewer.R
import com.example.simpsonsviewer.data.RelatedTopics

class SimpsonsCustomAdapter(
    private var itemsList: ArrayList<RelatedTopics>,
    private val onSimpsonsTextClickListener: SimpsonsTextClickListener
) :
    RecyclerView.Adapter<SimpsonsCustomAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.simpsons_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        val replace = item.Text.split("-")
        holder.itemTextView.text = replace[0]

        holder.itemView.setOnClickListener {
            onSimpsonsTextClickListener.onSimpsonsTextClickListener(item)
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}
