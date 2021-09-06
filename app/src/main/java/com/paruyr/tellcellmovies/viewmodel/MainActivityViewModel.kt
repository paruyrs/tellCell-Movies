package com.paruyr.tellcellmovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paruyr.tellcellmovies.model.Movies
import com.paruyr.tellcellmovies.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<Movies>? = null

    fun getUser(): LiveData<Movies>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }

}