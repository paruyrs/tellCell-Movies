package com.paruyr.tellcellmovies.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    var id: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("adult")
    var adult: Boolean = false,
    @SerializedName("vote_average")
    var voteAverage: Double = 0.0,
    @SerializedName("release_date")
    var premiereDate: String = ""
)

