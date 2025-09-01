package com.pulseshift.postscompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pulseshift.postscompose.model.Post
import com.pulseshift.postscompose.model.UIState
import com.pulseshift.postscompose.repository.PostsRepository
import kotlinx.coroutines.launch



class PostsViewModel: ViewModel() {
    val postsRepository = PostsRepository()

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    private val _uiState = MutableLiveData(UIState())
    val uiState: LiveData<UIState> = _uiState
//    init {
//        _uiState.value = UIState() // Assuming UIState has default constructor values
//    }


    fun fetchPosts(){

        viewModelScope.launch {
            _uiState.value = _uiState.value?.copy(isLoading = true)
            val response = postsRepository.fetchPosts()
            if (response.isSuccessful){
                _uiState.value = _uiState.value?.copy(success = "Fetch posts successfully", isLoading = false)
                _posts.postValue(response.body())
            }
            else{
                _uiState.value = _uiState.value?.copy(error = response.errorBody()?.string(), isLoading = false)

            }
        }
    }
}