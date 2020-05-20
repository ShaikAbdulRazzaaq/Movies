package com.assignment.movies.interfaces

import com.assignment.movies.data.MainModelClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GetDataFromMovieDB {
    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Call<MainModelClass?>?

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Call<MainModelClass?>?
}
