package com.haroldcalayan.movieapp.domain.use_case

import com.haroldcalayan.movieapp.data.repository.MovieRepository
import javax.inject.Inject

class UpdateWatchlistUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(id: Int, isOnMyWatchlist: Boolean) {
        return movieRepository.updateWatchlist(id, isOnMyWatchlist)
    }

}