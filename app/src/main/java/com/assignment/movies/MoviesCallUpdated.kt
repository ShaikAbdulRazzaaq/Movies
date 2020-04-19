package com.assignment.movies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesCallUpdated {
    @GET("/movie/upcoming")
    fun getUpdated(
        @Query("page") pagesize: Int,
        @Query("language") language: String?,
        @Query("apiKey") ApiKey: String?
    ): Call<Movies?>?
}