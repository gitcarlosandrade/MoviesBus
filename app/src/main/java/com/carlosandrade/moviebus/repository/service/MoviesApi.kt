package com.carlosandrade.moviebus.repository.service

import com.carlosandrade.moviebus.repository.entity.MostPopularMovies
import io.reactivex.Single
import retrofit2.http.GET

interface MoviesApi {

    companion object {
        const val API_VERSION = "3"
    }

    @GET("$API_VERSION/discover/movie?sort_by=popularity.desc")
    fun getMostPopularMovies(): Single<MostPopularMovies>
}