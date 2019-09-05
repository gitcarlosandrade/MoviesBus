package com.carlosandrade.moviebus.presenter.model

data class Movie(
    val id: Int,
    val title: String,
    val year: String,
    val vote: String,
    val genre: String,
    val actors: String,
    val image: String
)