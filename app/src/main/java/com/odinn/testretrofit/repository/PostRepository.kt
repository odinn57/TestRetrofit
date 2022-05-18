package com.odinn.testretrofit.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.odinn.testretrofit.api.NetworkService
import com.odinn.testretrofit.model.Post
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class PostRepository() {
    var postsList: List<Post> = emptyList()

    suspend fun getPosts(): List<Post> {
        val response = NetworkService().getInstance().getJSONApi().getAllPosts().awaitResponse()
        if (response.isSuccessful) {
            val data = response.body()!!
            Log.d("Repository", data.toString())
            postsList = data.toList()
        }
        return postsList
    }
}