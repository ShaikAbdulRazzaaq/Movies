package com.assignment.movies

import com.assignment.movies.interfaces.GetDataFromMovieDB
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory.create

object RetrofitSingleton {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    fun instance(): GetDataFromMovieDB {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(GetDataFromMovieDB::class.java)
    }
}