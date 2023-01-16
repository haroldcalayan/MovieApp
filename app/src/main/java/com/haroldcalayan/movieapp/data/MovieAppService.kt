package com.haroldcalayan.movieapp.data

import com.haroldcalayan.movieapp.data.model.MovieItem

interface MovieAppService {

    suspend fun getMovieList() : List<MovieItem>
}