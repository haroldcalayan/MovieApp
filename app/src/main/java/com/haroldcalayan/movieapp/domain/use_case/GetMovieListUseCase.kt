package com.haroldcalayan.movieapp.domain.use_case

import com.haroldcalayan.movieapp.common.Response
import com.haroldcalayan.movieapp.data.repository.MovieRepository
import com.haroldcalayan.movieapp.data.source.local.entity.MovieItemEntity
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke() : Response<List<MovieItemEntity>?> {
        return Response.Success(movieRepository.getMovieList())
    }

}