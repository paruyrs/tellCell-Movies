package com.paruyr.tellcellmovies.model

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("title")
    var title: String = "",

    @SerializedName("overview")
    var overview: String = "",

    @SerializedName("budget")
    var budget: Double = 0.0,

    @SerializedName("revenue")
    var revenue: Double = 0.0
)
