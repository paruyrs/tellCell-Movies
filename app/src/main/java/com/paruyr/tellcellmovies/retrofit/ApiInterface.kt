package com.paruyr.tellcellmovies.retrofit

import com.paruyr.tellcellmovies.model.Movies
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("services")
    fun getServices(): Call<Movies>

}