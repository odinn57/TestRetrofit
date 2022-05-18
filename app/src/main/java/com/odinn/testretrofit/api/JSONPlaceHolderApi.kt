package com.odinn.testretrofit.api

import com.odinn.testretrofit.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    fun getPostWithID(@Path("id") id:Int): Call<Post>

    @GET("/posts/")
    fun getAllPosts():Call<List<Post>>
}