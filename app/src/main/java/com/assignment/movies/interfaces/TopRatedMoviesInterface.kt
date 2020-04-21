package com.assignment.movies.interfaces

import com.assignment.movies.dataTopRated.MoviesTopRated
import com.assignment.movies.dataTopRated.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TopRatedMoviesInterface {
    @GET("movie/top_rated/")
    fun getTopRatedMovies(
        @Query("api_Key") ApiKey: String?
    ): Call<List<MoviesTopRated>>?
}