package com.carlosandrade.moviebus.repository.local.entity

import com.google.gson.annotations.SerializedName


data class MostPopularMovies(
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    @SerializedName("results") val movies: List<Movie?>? = null,
    val page: Int? = null
)

