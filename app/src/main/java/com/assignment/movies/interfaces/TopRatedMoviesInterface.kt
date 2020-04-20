package com.assignment.movies.interfaces

import com.assignment.movies.dataTopRated.MoviesTopRated
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TopRatedMoviesInterface {
    @GET("movie/top_rated")
    fun getUpcomingMovies(
        @Query("api_Key") ApiKey: String?
    ): Single<MoviesTopRated>?
}