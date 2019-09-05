package com.carlosandrade.moviebus.view.holder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carlosandrade.moviebus.R
import com.carlosandrade.moviebus.presenter.model.Movie
import com.carlosandrade.util.loadImage

class MovieItemViewHolder(val view: View, val listener: (Int) -> Unit) :
    RecyclerView.ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)
    private val year = view.findViewById<TextView>(R.id.releaseYear)
    private val vote = view.findViewById<TextView>(R.id.voteAverage)
    private val genre = view.findViewById<TextView>(R.id.genre)
    private val details = view.findViewById<Button>(R.id.details)
    private val poster = view.findViewById<ImageView>(R.id.moviePoster)

    fun bind(movie: Movie) {

        title.text = movie.title
        year.text = movie.year
        vote.text = movie.vote
        genre.text = movie.genre
        poster.loadImage(movie.image)

        details.setOnClickListener { listener(movie.id) }
    }
}