package com.assignment.movies.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.assignment.movies.dataTopRated.MoviesTopRated
import com.assignment.movies.dataTopRated.Result
import com.assignment.movies.repository.topRatedRepo

class ViewModelTopRated : ViewModel() {
    private val repository = topRatedRepo()
    val showProgress: LiveData<Boolean>
     val topRated: LiveData<List<MoviesTopRated>>

    init {
        this.showProgress = repository.showprogress
        this.topRated = repository.moviesTopRated
    }

    fun changeState() {
        repository.changeState()
    }

    fun networkCall() {
        repository.networkCall()
    }


}