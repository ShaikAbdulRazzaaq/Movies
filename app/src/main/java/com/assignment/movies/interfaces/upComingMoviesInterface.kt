package com.assignment.movies.interfaces


import com.assignment.movies.dataUpcoming.UpcomingMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface upComingMoviesInterface {
    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_Key") ApiKey: String?
    ): Call<UpcomingMovies>?

}