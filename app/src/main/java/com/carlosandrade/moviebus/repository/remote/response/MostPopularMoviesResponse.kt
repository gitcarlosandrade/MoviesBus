package com.carlosandrade.moviebus.repository.remote.response

import com.google.gson.annotations.SerializedName


data class MostPopularMoviesResponse(
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    @SerializedName("results") val movieResponses: List<MovieResponse?>? = null,
    val page: Int? = null
)

