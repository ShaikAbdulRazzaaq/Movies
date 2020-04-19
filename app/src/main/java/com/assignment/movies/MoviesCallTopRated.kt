package com.assignment.movies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesCallTopRated {
    @GET("movie/top_rated")
    fun getTopRated(
        @Query("page") pagesize: Int,
        @Query("language") language: String?,
        @Query("apiKey") ApiKey: String?
    ): Call<Movies>?
}