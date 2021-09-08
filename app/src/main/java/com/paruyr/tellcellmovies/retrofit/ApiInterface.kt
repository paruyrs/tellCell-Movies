package com.paruyr.tellcellmovies.retrofit

import com.paruyr.tellcellmovies.BuildConfig
import com.paruyr.tellcellmovies.model.MovieDetails
import com.paruyr.tellcellmovies.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("movie/{type}?api_key=" + BuildConfig.MOVIES_API_KEY)
    fun getMovies(@Path("type") type: String): Call<Movies>

    @GET("movie/{id}?api_key=" + BuildConfig.MOVIES_API_KEY)
    fun getDetails(@Path("id") id: String): Call<MovieDetails>

}