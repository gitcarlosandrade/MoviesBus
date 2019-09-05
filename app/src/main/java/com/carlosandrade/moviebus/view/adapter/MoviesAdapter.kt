package com.carlosandrade.moviebus.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlosandrade.moviebus.R
import com.carlosandrade.moviebus.presenter.model.Movie
import com.carlosandrade.moviebus.view.holder.MovieItemViewHolder

class MoviesAdapter(
    private val movies: List<Movie>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<MovieItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_view, parent, false)

        return MovieItemViewHolder(view, listener)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}