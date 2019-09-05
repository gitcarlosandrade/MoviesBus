package com.carlosandrade.moviebus.repository.remote

import com.carlosandrade.moviebus.repository.remote.response.ConfigurationResponse
import com.carlosandrade.moviebus.repository.remote.response.MostPopularMoviesResponse
import io.reactivex.Single

interface RemoteDataSource {

    fun getMostPopularMovies() : Single<MostPopularMoviesResponse>
    fun getConfiguration(): Single<ConfigurationResponse>
}