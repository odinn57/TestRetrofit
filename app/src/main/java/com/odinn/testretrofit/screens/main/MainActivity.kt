package com.odinn.testretrofit.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.odinn.testretrofit.databinding.ActivityMainBinding
import com.odinn.testretrofit.model.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var postsAdapter = PostsAdapter()
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    private var postList:List<Post> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rv_posts.adapter = postsAdapter
        viewModel.getPostList().observe(this, Observer {
            postsAdapter.setList(it)
        })

        binding.btnGet.setOnClickListener {
            viewModel.updatePosts()
            viewModel.getPostList().observe(this, Observer {
                it?.let {
                    postsAdapter.setList(it)
                }
            })
        }
    }


}