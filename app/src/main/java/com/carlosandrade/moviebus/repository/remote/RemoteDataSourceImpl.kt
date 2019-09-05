package com.carlosandrade.moviebus.repository.remote

import com.carlosandrade.moviebus.repository.remote.response.ConfigurationResponse
import com.carlosandrade.moviebus.repository.remote.response.MostPopularMoviesResponse
import com.carlosandrade.moviebus.repository.service.MoviesApi
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api : MoviesApi) : RemoteDataSource {
    override fun getConfiguration(): Single<ConfigurationResponse> {
        return api.getConfiguration()
    }

    override fun getMostPopularMovies(): Single<MostPopularMoviesResponse> {
        return api.getMostPopularMovies()
    }
}