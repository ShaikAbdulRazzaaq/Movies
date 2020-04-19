package com.assignment.movies

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Movies : Serializable {
    @SerializedName("poster_path")
    @Expose
    var poster_path: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("vote_average")
    @Expose
    var vote_average: String? = null

    @SerializedName("overview")
    @Expose
    var overview: String? = null

    @SerializedName("release_date")
    @Expose
    var release_date: String? = null

}