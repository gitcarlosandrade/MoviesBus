package com.carlosandrade.moviebus.view.activity

import android.os.Bundle
import com.carlosandrade.moviebus.R
import com.carlosandrade.moviebus.presenter.model.Movie
import com.carlosandrade.moviebus.presenter.movies.MoviesListContract
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MoviesListActivity : DaggerAppCompatActivity(), MoviesListContract.View {

    @Inject
    lateinit var presenter : MoviesListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.subscribe()
    }

    override fun showMovies(movies: List<Movie>) {

    }

    override fun hideLoader() {
    }

    override fun showLoader() {
    }

    override fun hideMovies() {
    }
}
