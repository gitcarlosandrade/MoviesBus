package com.carlosandrade.moviebus.presenter.movies

import com.carlosandrade.moviebus.repository.remote.response.MostPopularMoviesResponse
import com.carlosandrade.moviebus.presenter.BasePresenter
import com.carlosandrade.moviebus.presenter.model.Movie

interface MoviesListContract {

    interface Presenter : BasePresenter {
        fun handleSuccess(pair: Pair<MostPopularMoviesResponse, String>)
        fun handleError(throwable: Throwable)
        fun getMovies()
    }

    interface View {
        fun showMovies(movies: List<Movie>)
        fun hideLoader()
        fun showLoader()
        fun hideMovies()
    }
}