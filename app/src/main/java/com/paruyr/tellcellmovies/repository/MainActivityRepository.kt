package com.paruyr.tellcellmovies.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.paruyr.tellcellmovies.model.Movies
import com.paruyr.tellcellmovies.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<Movies>()

    fun getServicesApiCall(): MutableLiveData<Movies> {

        val call = RetrofitClient.apiInterface.getMovies("popular")

        call.enqueue(object : Callback<Movies> {
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<Movies>,
                response: Response<Movies>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
                val movies = data!!.movies.filter { movie -> !movie.adult  }
                serviceSetterGetter.value = Movies(movies)
            }
        })

        return serviceSetterGetter
    }
}