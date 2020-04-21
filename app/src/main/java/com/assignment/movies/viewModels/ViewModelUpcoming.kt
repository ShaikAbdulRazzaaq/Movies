package com.assignment.movies.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.movies.dataUpcoming.Result

class ViewModelUpcoming:ViewModel() {
    var mutableLiveDataUpcomingMovies: MutableLiveData<Result>?=null
}