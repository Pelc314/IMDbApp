package com.example.imdbapp.domain.usecase.getmoviedetails

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.MovieDetails
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val imdbRepository: ImdbRepository
) {
    suspend fun getMovieDetails(query: String): Flow<Resource<MovieDetails>> {
        return imdbRepository.getMovieDetails(query)
    }
}
