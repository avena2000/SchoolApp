package com.sistemexico.schoolmanager.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sistemexico.schoolmanager.Post
import com.sistemexico.schoolmanager.R

class PostViewHolder(view: View) : ViewHolder(view) {

    val title = view.findViewById<TextView>(R.id.titleTemplate)
    val subtitle = view.findViewById<TextView>(R.id.textTemplate)

    fun render(post: Post) {
        title.text = post.title
        subtitle.text = post.body

    }

}