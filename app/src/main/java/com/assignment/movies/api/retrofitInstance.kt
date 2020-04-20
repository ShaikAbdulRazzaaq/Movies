package com.assignment.movies.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitInstance {
    var retrofit: Retrofit? = null
        get() {
            if (field == null) {
                field = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3")
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return field
        }
        private set
}