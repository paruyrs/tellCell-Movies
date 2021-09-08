package com.paruyr.tellcellmovies.model

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("results") var movies: List<Movie> = emptyList()
)
