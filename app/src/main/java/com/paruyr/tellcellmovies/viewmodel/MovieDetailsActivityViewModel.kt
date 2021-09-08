package com.paruyr.tellcellmovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paruyr.tellcellmovies.model.MovieDetails
import com.paruyr.tellcellmovies.repository.MovieDetailsActivityRepository

class MovieDetailsActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<MovieDetails>? = null

    fun getMovieDetails(movieID : String): LiveData<MovieDetails>? {
        servicesLiveData = MovieDetailsActivityRepository.getServicesApiCall(movieID)
        return servicesLiveData
    }

}
