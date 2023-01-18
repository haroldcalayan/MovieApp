package com.haroldcalayan.movieapp.domain.use_case

import com.haroldcalayan.movieapp.common.Response
import com.haroldcalayan.movieapp.data.model.MovieItem
import com.haroldcalayan.movieapp.data.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(id: Int) : Response<MovieItem?> {
        return Response.Success(movieRepository.getMovieDetails(id))
    }
}