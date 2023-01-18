package com.haroldcalayan.movieapp.data.model

data class MovieItem(
    val id: Int,
    val title: String,
    val imageId: Int,
    val description: String,
    val rating: Double,
    val duration: String,
    val genre: String,
    val releaseDate: String,
    val trailerLink: String,
    val isOnMyWatchList: Boolean
)
