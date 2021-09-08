package com.paruyr.tellcellmovies.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.paruyr.tellcellmovies.model.MovieDetails
import com.paruyr.tellcellmovies.model.Movies
import com.paruyr.tellcellmovies.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieDetailsActivityRepository {

    val serviceSetterGetter = MutableLiveData<MovieDetails>()

    fun getServicesApiCall(movieID: String): MutableLiveData<MovieDetails> {

        val call = RetrofitClient.apiInterface.getDetails(movieID)

        call.enqueue(object : Callback<MovieDetails> {
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<MovieDetails>,
                response: Response<MovieDetails>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
                val movieDetails = data!!
                serviceSetterGetter.value = movieDetails
            }
        })

        return serviceSetterGetter
    }
}

