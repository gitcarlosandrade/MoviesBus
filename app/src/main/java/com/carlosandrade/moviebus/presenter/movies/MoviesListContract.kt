package com.carlosandrade.moviebus.presenter.movies

import com.carlosandrade.moviebus.repository.entity.MostPopularMovies
import com.carlosandrade.moviebus.presenter.BasePresenter
import com.carlosandrade.moviebus.presenter.model.Movie

interface MoviesListContract {

    interface Presenter : BasePresenter {
        fun handleSuccess(mostPopularMovies: MostPopularMovies)
        fun handleError(throwable: Throwable)
    }

    interface View {
        fun showMovies(movies: List<Movie>)
        fun hideLoader()
        fun showLoader()
        fun hideMovies()
    }
}