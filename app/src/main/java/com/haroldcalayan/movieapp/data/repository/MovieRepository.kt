package com.haroldcalayan.movieapp.data.repository

import com.haroldcalayan.movieapp.R
import com.haroldcalayan.movieapp.common.base.BaseRepository
import com.haroldcalayan.movieapp.data.MovieAppService
import com.haroldcalayan.movieapp.data.model.MovieItem
import com.haroldcalayan.movieapp.data.source.local.database.AppDatabase
import com.haroldcalayan.movieapp.data.source.local.entity.MovieItemEntity
import com.haroldcalayan.movieapp.domain.mapper.toMovieItemEntity
import java.util.ArrayList

interface MovieRepository {
    suspend fun getMovieList() : List<MovieItemEntity>?

    suspend fun getMovieDetails(id: Int) : MovieItemEntity?

    suspend fun updateWatchlist(id: Int, isOnWatchlist: Boolean)

}

class MovieRepositoryImpl(private val db: AppDatabase) : BaseRepository(), MovieRepository {

    override suspend fun getMovieList(): List<MovieItemEntity>? {
        if (db.movieItemDao().all().isNullOrEmpty()) {
            getDummyMovieList().forEach {
                db.movieItemDao().insert(it.toMovieItemEntity())
            }
        }
        return db.movieItemDao().all()?.toList()
    }

    override suspend fun getMovieDetails(id: Int): MovieItemEntity? {
        return db.movieItemDao().get(id)
    }

    override suspend fun updateWatchlist(id: Int, isOnWatchlist: Boolean) {
        return db.movieItemDao().updateWatchlist(id, isOnWatchlist)
    }

    private fun getDummyMovieList() : List<MovieItem>{
        val movieList = ArrayList<MovieItem>()
        movieList.add(
            MovieItem(
                id = 1,
                title = "Tenet",
                imageId = R.drawable.tenet,
                description = "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                rating = 7.8,
                duration = "2h 30 min",
                genre = "Action, Sci-Fi",
                releaseDate = "3 September 2020",
                trailerLink = "https://www.youtube.com/watch?v=LdOM0x0XDMo",
                isOnMyWatchList = false
            )
        )
        movieList.add(
            MovieItem(
                id = 2,
                title = "Spider-Man: Into the Spider-Verse",
                imageId = R.drawable.spider_man,
                description = "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities.",
                rating = 8.4,
                duration = "1h 57min",
                genre = "Action, Animation, Adventure",
                releaseDate = "14 December 2018",
                trailerLink = "https://www.youtube.com/watch?v=tg52up16eq0",
                isOnMyWatchList = false
            )
        )
        movieList.add(
            MovieItem(
                id = 3,
                title = "Knives Out",
                imageId = R.drawable.knives_out,
                description = " A detective investigates the death of a patriarch of an eccentric, combative family.",
                rating = 7.9,
                duration = "2h 10min",
                genre = "Comedy, Crime, Drama",
                releaseDate = "27 November 2019",
                trailerLink = "https://www.youtube.com/watch?v=qGqiHJTsRkQ",
                isOnMyWatchList = false
            )
        )
        movieList.add(
            MovieItem(
                id = 4,
                title = "Guardians of the Galaxy",
                imageId = R.drawable.guardians_of_the_galaxy,
                description = "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.",
                rating = 8.0,
                duration = "2h 1min",
                genre = "Action, Adventure, Comedy",
                releaseDate = "1 August 2014",
                trailerLink = "https://www.youtube.com/watch?v=d96cjJhvlMA",
                isOnMyWatchList = false
            )
        )
        movieList.add(
            MovieItem(
                id = 5,
                title = "Age of Ultron",
                imageId = R.drawable.avengers,
                description = "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
                rating = 7.3,
                duration = "2h 21min",
                genre = "Action, Adventure, Sci-Fi",
                releaseDate = "1 May 2015",
                trailerLink = "https://www.youtube.com/watch?v=tmeOjFno6Do",
                isOnMyWatchList = false
            )
        )

        return movieList
    }


}