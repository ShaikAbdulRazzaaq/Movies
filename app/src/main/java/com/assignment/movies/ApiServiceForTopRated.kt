package com.assignment.movies

import retrofit2.http.GET
import retrofit2.http.Query

const val apiKey: String = "73884879dfa3d28cc666c9b18d79c862"

// Upcoming URL ::https://api.themoviedb.org/3/movie/upcoming?api_key=73884879dfa3d28cc666c9b18d79c862&language=en-US&page=1
//TopRated URL ::https://api.themoviedb.org/3/movie/top_rated?api_key=73884879dfa3d28cc666c9b18d79c862&language=en-US
interface ApiServiceForTopRated {
    @GET("movie/upcoming")
    fun getTopRated(
        @Query("apiKey") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    )
}