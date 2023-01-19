package com.haroldcalayan.movieapp.di

import com.haroldcalayan.movieapp.data.repository.MovieRepository
import com.haroldcalayan.movieapp.domain.use_case.GetMovieDetailUseCase
import com.haroldcalayan.movieapp.domain.use_case.GetMovieListUseCase
import com.haroldcalayan.movieapp.domain.use_case.UpdateWatchlistUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMovieListUseCase(movieRepository: MovieRepository) = GetMovieListUseCase(movieRepository)

    @Provides
    @Singleton
    fun provideGetMovieDetailUseCase(movieRepository: MovieRepository) = GetMovieDetailUseCase(movieRepository)

    @Provides
    @Singleton
    fun provideUpdateWatchlistUseCase(movieRepository: MovieRepository) = UpdateWatchlistUseCase(movieRepository)
}