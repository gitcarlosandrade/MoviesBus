package com.carlosandrade.moviebus.repository.remote

import com.carlosandrade.moviebus.repository.entity.MostPopularMovies
import io.reactivex.Single

interface RemoteDataSource {

    fun getMostPopularMovies() : Single<MostPopularMovies>
}