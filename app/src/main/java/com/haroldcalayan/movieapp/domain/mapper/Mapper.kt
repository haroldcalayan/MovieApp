package com.haroldcalayan.movieapp.domain.mapper

import com.haroldcalayan.movieapp.data.model.MovieItem
import com.haroldcalayan.movieapp.data.source.local.entity.MovieItemEntity

fun MovieItem.toMovieItemEntity() = MovieItemEntity(
    id = id,
    title = title,
    imageId = imageId,
    description = description,
    rating = rating,
    duration = duration,
    genre = genre,
    releaseDate = releaseDate,
    trailerLink = trailerLink,
    isOnMyWatchList = isOnMyWatchList
)
