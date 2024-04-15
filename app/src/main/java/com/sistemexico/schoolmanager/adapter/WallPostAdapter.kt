package com.sistemexico.schoolmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sistemexico.schoolmanager.R

class WallPostAdapter(private val dataList: List<Data>) :
    RecyclerView.Adapter<WallPostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallPostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WallPostViewHolder(layoutInflater.inflate(R.layout.wall_post, parent, false))
    }

    override fun onBindViewHolder(holder: WallPostViewHolder, position: Int) {
        val data = dataList[position]
        holder.render(data)
    }


    override fun getItemCount(): Int {
        /*
                println(dataList.size)
        */
        return dataList.size
    }

    data class Data(
        val profilePicture: String,
        val profileUsername: String,
        val time: String,
        val text: String,
        val listItems: List<String>
    )

}