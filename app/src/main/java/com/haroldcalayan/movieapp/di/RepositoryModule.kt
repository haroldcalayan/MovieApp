package com.haroldcalayan.movieapp.di

import com.haroldcalayan.movieapp.data.repository.MovieRepository
import com.haroldcalayan.movieapp.data.repository.MovieRepositoryImpl
import com.haroldcalayan.movieapp.data.source.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(db: AppDatabase): MovieRepository {
        return MovieRepositoryImpl(db)
    }
}