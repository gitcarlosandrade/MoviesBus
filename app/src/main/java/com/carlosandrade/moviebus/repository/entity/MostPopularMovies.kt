package com.carlosandrade.moviebus.repository.entity

import com.google.gson.annotations.SerializedName


data class MostPopularMovies(
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    val page: Int? = null,
    val movies: List<Movie?>? = null
)

