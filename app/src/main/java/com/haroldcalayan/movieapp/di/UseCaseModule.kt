package com.haroldcalayan.movieapp.di

import com.haroldcalayan.movieapp.data.repository.MovieRepository
import com.haroldcalayan.movieapp.domain.use_case.GetMovieListUseCase
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
}