package com.haroldcalayan.movieapp.presentation.movie_details

import androidx.activity.viewModels
import com.haroldcalayan.movieapp.R
import com.haroldcalayan.movieapp.common.base.BaseActivity
import com.haroldcalayan.movieapp.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : BaseActivity<MovieDetailsViewModel, ActivityMovieDetailsBinding>() {

    override val layoutId = R.layout.activity_movie_details
    override val viewModel: MovieDetailsViewModel by viewModels()
}