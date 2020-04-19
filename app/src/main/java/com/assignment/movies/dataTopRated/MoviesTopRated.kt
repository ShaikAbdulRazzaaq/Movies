package com.assignment.movies.dataTopRated


import com.google.gson.annotations.SerializedName

data class MoviesTopRated(
    val page: Int,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)