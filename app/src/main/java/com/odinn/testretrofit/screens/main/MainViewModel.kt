package com.odinn.testretrofit.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odinn.testretrofit.model.Post
import com.odinn.testretrofit.repository.PostRepository
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private var repository:PostRepository = PostRepository()
    private var postList:MutableLiveData<List<Post>> = MutableLiveData()
    init {
        viewModelScope.launch {
            postList.value = repository.getPosts()
        }
    }

    fun updatePosts(){
        viewModelScope.launch {
            postList.value = repository.getPosts()
        }
    }
    fun getPostList() = postList
}