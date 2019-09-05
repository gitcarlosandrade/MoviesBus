package com.carlosandrade.moviebus.repository

import com.carlosandrade.moviebus.repository.remote.response.MostPopularMoviesResponse
import io.reactivex.Completable
import io.reactivex.Single

interface MoviesRepository {

    fun getMostPopularMovies(): Single<MostPopularMoviesResponse>
    fun getImageUrl() : Single<String?>
    fun getConfiguration() : Completable
}