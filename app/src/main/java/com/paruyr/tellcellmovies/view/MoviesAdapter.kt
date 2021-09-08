package com.paruyr.tellcellmovies.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paruyr.tellcellmovies.model.Movie

import com.paruyr.tellcellmovies.databinding.MovieItemBinding
import com.paruyr.tellcellmovies.utils.showHide

class MoviesAdapter(
    private val listener: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieHolder>(){

    /**
     * List of news articles
     */
    private var movies: List<Movie> = emptyList()
    private lateinit var binding: MovieItemBinding


    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieHolder(binding)
    }


    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(movieHolder: MovieHolder, position: Int) =
        movieHolder.bind(movies[position],binding, listener)


    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = movies.size

    fun replaceItems(items: List<Movie>) {
        movies = items
        notifyDataSetChanged()
    }

    /**
     * View Holder Pattern
     */
    class MovieHolder(binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {


        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(movie: Movie, binding: MovieItemBinding, listener: (Movie) -> Unit) = with(itemView) {

            binding.movieTitleTextView.text = movie.title
            binding.voteAverageTextView.text = movie.voteAverage.toString()
            binding.adultTextView.visibility = showHide(movie.adult)
            binding.releaseDateTextView.text = movie.premiereDate

            setOnClickListener { listener(movie) }

        }
    }
}