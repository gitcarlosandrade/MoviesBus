package com.carlosandrade.moviebus.repository

import com.carlosandrade.moviebus.repository.entity.MostPopularMovies
import com.carlosandrade.moviebus.repository.remote.RemoteDataSource
import com.carlosandrade.moviebus.repository.service.MoviesApi
import io.reactivex.Single
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val remote: RemoteDataSource)
    : MoviesRepository {
    override fun getMostPopularMovies(): Single<MostPopularMovies> {
        return remote.getMostPopularMovies()
    }
}