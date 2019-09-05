package com.carlosandrade.moviebus.repository.remote

import com.carlosandrade.moviebus.repository.entity.MostPopularMovies
import com.carlosandrade.moviebus.repository.service.MoviesApi
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api : MoviesApi) : RemoteDataSource {

    override fun getMostPopularMovies(): Single<MostPopularMovies> {
        return api.getMostPopularMovies()
    }
}