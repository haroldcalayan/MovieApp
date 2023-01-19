package com.haroldcalayan.movieapp.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.haroldcalayan.movieapp.R
import com.haroldcalayan.movieapp.common.base.BaseActivity
import com.haroldcalayan.movieapp.data.source.local.entity.MovieItemEntity
import com.haroldcalayan.movieapp.databinding.ActivityMainBinding
import com.haroldcalayan.movieapp.presentation.movie_details.MovieDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(),
    MovieAdapter.MovieAdapterListener {

    override val layoutId = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    private lateinit var movieAdapter: MovieAdapter

    private var isSortedByTitle = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    override fun onItemClick(item: MovieItemEntity) {
        item.id?.let { openMovieDetailsScreen(it) }
    }

    override fun initViews() {
        super.initViews()
        viewModel.getMovieList()
        observe()

        binding.textviewSort.setOnClickListener {
            if (!isSortedByTitle) {
                isSortedByTitle = true
                viewModel.movieList.value?.let { movieAdapter.sortMovieItemByReleaseDate(it) }
            } else {
                isSortedByTitle = false
                viewModel.movieList.value?.let { movieAdapter.sortMovieItemByTitle(it) }
            }
        }
    }

    override fun observe() {
        super.observe()
        viewModel.movieList.observe(this, {
            movieAdapter = MovieAdapter(it ?: emptyList(), this)
            binding.recyclerviewMovieList.adapter = movieAdapter
        })
    }

    private fun openMovieDetailsScreen(movieId: Int) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_ID, movieId)
        startActivity(intent)
    }

    companion object {
        const val MOVIE_ID = "movieId"
    }
}