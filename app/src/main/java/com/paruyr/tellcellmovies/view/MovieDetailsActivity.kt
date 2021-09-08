package com.paruyr.tellcellmovies.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paruyr.tellcellmovies.R
import com.paruyr.tellcellmovies.databinding.ActivityMovieDetailsBinding
import com.paruyr.tellcellmovies.viewmodel.MovieDetailsActivityViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.paruyr.tellcellmovies.viewmodel.MainActivityViewModel

class MovieDetailsActivity : AppCompatActivity() {
    lateinit var context: Context

    lateinit var movieDetailsActivityViewModel: MovieDetailsActivityViewModel

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        movieDetailsActivityViewModel = ViewModelProvider(this).get(MovieDetailsActivityViewModel::class.java)

        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movieID = intent.getStringExtra("movieID")

        movieID?.let { movieDetailsActivityViewModel.getMovieDetails(it) }!!
            .observe(this, Observer { movieDetails ->
                binding.movieTitleTextView.text = movieDetails.title
                binding.overviewTextView.text = movieDetails.overview
                binding.budgetTextView.text = movieDetails.budget.toString()
                binding.revenueTextView.text = movieDetails.revenue.toString()


            })


    }
}