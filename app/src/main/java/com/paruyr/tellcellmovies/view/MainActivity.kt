package com.paruyr.tellcellmovies.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.paruyr.tellcellmovies.databinding.ActivityMainBinding
import com.paruyr.tellcellmovies.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this@MainActivity
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        adapter = MoviesAdapter {
            val intent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
            intent.putExtra("movieID", it.id)
            startActivity(intent)
        }

        binding.moviesRecyclerView.adapter = adapter
        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(this)

        mainActivityViewModel.servicesLiveData?.value?.let { adapter.replaceItems(it.movies) }

        binding.btnClick.setOnClickListener {
            mainActivityViewModel.getMovies()!!.observe(this, Observer { serviceSetterGetter ->
                val movies = serviceSetterGetter.movies
                adapter.replaceItems(movies)
            })
        }
    }
}