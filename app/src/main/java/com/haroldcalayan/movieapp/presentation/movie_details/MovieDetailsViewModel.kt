package com.haroldcalayan.movieapp.presentation.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haroldcalayan.movieapp.common.base.BaseViewModel
import com.haroldcalayan.movieapp.data.model.MovieItem
import com.haroldcalayan.movieapp.domain.use_case.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel  @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : BaseViewModel() {

    private val _movieDetail = MutableLiveData<MovieItem?>()
    val movieDetail: LiveData<MovieItem?> = _movieDetail

    fun getMovieDetails(id: Int) {
        invoke {
            _movieDetail.postValue(getMovieDetailUseCase(id).data)
        }
    }
}