package com.carlosandrade.moviebus.repository

import com.carlosandrade.moviebus.repository.entity.MostPopularMovies
import io.reactivex.Single

interface MoviesRepository {

    fun getMostPopularMovies(): Single<MostPopularMovies>
}