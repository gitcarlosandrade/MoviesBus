package com.carlosandrade.moviebus.repository

import com.carlosandrade.moviebus.repository.local.LocalDataSource
import com.carlosandrade.moviebus.repository.remote.response.MostPopularMoviesResponse
import com.carlosandrade.moviebus.repository.remote.RemoteDataSource
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val remote: RemoteDataSource,
                                               private val local: LocalDataSource)
    : MoviesRepository {

    override fun getMostPopularMovies(): Single<MostPopularMoviesResponse> {
        return remote.getMostPopularMovies()
    }

    override fun getImageUrl(): Single<String?> {
        return Single.just(local.getUrlImage())
    }

    override fun getConfiguration() : Completable{
        return remote.getConfiguration()
            .doOnSuccess {
                local.saveUrlImage(config = it)
            }.ignoreElement()
    }
}