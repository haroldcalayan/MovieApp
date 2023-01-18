package com.haroldcalayan.movieapp.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.haroldcalayan.movieapp.R
import com.haroldcalayan.movieapp.common.base.BaseActivity
import com.haroldcalayan.movieapp.data.model.MovieItem
import com.haroldcalayan.movieapp.databinding.ActivityMainBinding
import com.haroldcalayan.movieapp.presentation.movie_details.MovieDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(),
    MovieAdapter.MovieAdapterListener {

    override val layoutId = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    override fun onItemClick(item: MovieItem) {
        openMovieDetailsScreen(item.id)
    }

    override fun initViews() {
        super.initViews()
        viewModel.getMovieList()
        observe()
    }

    /*private fun initMovieList() {
        val movieList = ArrayList<MovieItem>()
        movieList.add(
            MovieItem(
                title = "Tenet",
                description = "Armed with only one word, Tenet, and fighting for the survival of the entire world, a\n" +
                        "Protagonist journeys through a twilight world of international espionage on a mission that will\n" +
                        "unfold in something beyond real time.",
                rating = 7.8,
                duration = "2h 30 min",
                genre = "Action, Sci-Fi",
                releaseDate = "3 September 2020",
                trailerLink = "https://www.youtube.com/watch?v=LdOM0x0XDMo"
            )
        )
        movieList.add(
            MovieItem(
                title = "Spider-Man: Into the Spider-Verse",
                description = "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five\n" +
                        "spider-powered individuals from other dimensions to stop a threat for all realities.",
                rating = 8.4,
                duration = "1h 57min",
                genre = "Action, Animation, Adventure",
                releaseDate = "14 December 2018",
                trailerLink = "https://www.youtube.com/watch?v=tg52up16eq0"
            )
        )
    }*/

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