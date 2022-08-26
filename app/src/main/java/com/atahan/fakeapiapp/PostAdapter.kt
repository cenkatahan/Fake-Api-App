package com.atahan.fakeapiapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.atahan.fakeapiapp.model.Post

class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostHolder>() {

    class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.text_view_id)
        val title: TextView = itemView.findViewById(R.id.text_view_title)
        val body: TextView = itemView.findViewById(R.id.text_view_body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_post, parent, false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.id.text = posts[position].id.toString()
        holder.title.text = posts[position].title.toString()
        holder.body.text = posts[position].body.toString()
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}