package com.assignment.movies.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.assignment.movies.dataTopRated.MoviesTopRated
import com.assignment.movies.dataTopRated.Result
import com.assignment.movies.interfaces.TopRatedMoviesInterface
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class topRatedRepo {
    val showprogress = MutableLiveData<Boolean>()
    val moviesTopRated = MutableLiveData<List<MoviesTopRated>>()
    fun changeState() {
        showprogress.value = !(showprogress.value != null && showprogress.value!!)
    }

    fun networkCall() {
        showprogress.value = true
        val retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(TopRatedMoviesInterface::class.java)
        service.getTopRatedMovies("73884879dfa3d28cc666c9b18d79c862")?.enqueue(object :Callback<List<MoviesTopRated>>{
            override fun onFailure(call: Call<List<MoviesTopRated>>, t: Throwable) {
              showprogress.value=false
                Log.d("Failed",""+t.message)
            }

            override fun onResponse(
                call: Call<List<MoviesTopRated>>,
                response: Response<List<MoviesTopRated>>
            ) {
                showprogress.value=false
                Log.d("Success" , "Response : ${Gson().toJson(response.body())}")
                moviesTopRated.value=response.body()
            }

        })


    }
}