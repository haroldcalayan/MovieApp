package com.haroldcalayan.movieapp.presentation.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haroldcalayan.movieapp.common.base.BaseViewModel
import com.haroldcalayan.movieapp.data.source.local.entity.MovieItemEntity
import com.haroldcalayan.movieapp.domain.use_case.GetMovieDetailUseCase
import com.haroldcalayan.movieapp.domain.use_case.UpdateWatchlistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val updateWatchlistUseCase: UpdateWatchlistUseCase
) : BaseViewModel() {

    private val _movieDetail = MutableLiveData<MovieItemEntity?>()
    val movieDetail: LiveData<MovieItemEntity?> = _movieDetail

    fun getMovieDetails(id: Int) {
        invoke {
            _movieDetail.postValue(getMovieDetailUseCase(id).data)
        }
    }

    fun updateMyWatchlist(id: Int, isOnWatchList: Boolean) {
        invoke {
            updateWatchlistUseCase.invoke(id, isOnWatchList)
        }
    }
}