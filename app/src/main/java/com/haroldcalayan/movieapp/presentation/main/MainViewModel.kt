package com.haroldcalayan.movieapp.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haroldcalayan.movieapp.common.base.BaseViewModel
import com.haroldcalayan.movieapp.data.model.MovieItem
import com.haroldcalayan.movieapp.domain.use_case.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
): BaseViewModel() {

    private val _movieList = MutableLiveData<List<MovieItem>?>()
    val movieList: LiveData<List<MovieItem>?> = _movieList

    fun getMovieList() {
        invoke {
            _movieList.postValue(getMovieListUseCase.invoke().data)
        }
    }
}