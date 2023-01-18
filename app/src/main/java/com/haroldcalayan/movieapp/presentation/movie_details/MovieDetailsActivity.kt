package com.haroldcalayan.movieapp.presentation.movie_details

import android.widget.TextView
import androidx.activity.viewModels
import com.haroldcalayan.movieapp.R
import com.haroldcalayan.movieapp.common.base.BaseActivity
import com.haroldcalayan.movieapp.databinding.ActivityMovieDetailsBinding
import com.haroldcalayan.movieapp.presentation.main.MainActivity.Companion.MOVIE_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsActivity : BaseActivity<MovieDetailsViewModel, ActivityMovieDetailsBinding>() {

    override val layoutId = R.layout.activity_movie_details
    override val viewModel: MovieDetailsViewModel by viewModels()

    override fun initViews() {
        super.initViews()
        val movieId = intent.getIntExtra(MOVIE_ID, 0)
        viewModel.getMovieDetails(movieId)

        toolbarAction()

    }

    private fun toolbarAction() {
        binding.movieToolbarContainer.findViewById<TextView>(R.id.back_icon).setOnClickListener {
            onBackPressed()
        }
    }

    override fun observe() {
        super.observe()
        viewModel.movieDetail.observe(this, {
            it?.let { movieItem ->
                binding.textviewDetailsName.text = movieItem.title
                binding.imageviewDetailsPoster.setImageResource(movieItem.imageId)
                binding.textviewRatings.text = movieItem.rating.toString()
                binding.textviewShortDescription.text = movieItem.description
                binding.textviewGenre.text = movieItem.genre
                binding.textviewReleaseDate.text = movieItem.releaseDate
            }
        })
    }
}