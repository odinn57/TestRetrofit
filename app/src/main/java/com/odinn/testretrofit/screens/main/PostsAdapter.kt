package com.odinn.testretrofit.screens.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odinn.testretrofit.databinding.ItemPostBinding
import com.odinn.testretrofit.model.Post

class PostsAdapter:RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    private var postList:List<Post> = emptyList()

    class PostViewHolder(private val itemPostBinding: ItemPostBinding):RecyclerView.ViewHolder(itemPostBinding.root) {
        fun bind(post:Post){
            with(itemPostBinding){
                postId.text = post.id.toString()
                userId.text = post.userId.toString()
                title.text = post.title
                body.text = post.body
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPostBinding = ItemPostBinding.inflate(layoutInflater,parent,false)
        return PostViewHolder(itemPostBinding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int = postList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Post>){
        postList = list
        notifyDataSetChanged()
    }

}