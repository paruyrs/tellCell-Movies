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

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object : Callback<Movies> {
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<Movies>,
                response: Response<Movies>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                val movies = data!!.movies

                serviceSetterGetter.value = Movies(movies)
            }
        })

        return serviceSetterGetter
    }
}