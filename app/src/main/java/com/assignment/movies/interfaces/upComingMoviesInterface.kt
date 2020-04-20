package com.assignment.movies.interfaces


import com.assignment.movies.dataUpcoming.UpcomingMovies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

val base_url: String = "https://api.themoviedb.org/3/"
val api_key: String = "73884879dfa3d28cc666c9b18d79c862"

interface upComingMoviesInterface {
    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_Key") ApiKey: String?
    ): Single<UpcomingMovies>?

}