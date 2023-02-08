package com.example.imdbapp.domain.usecase

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.movie.Movie
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val imdbRepository: ImdbRepository
) {
    suspend fun getMovieDetails(query: String): Flow<Resource<Movie>> {
        return imdbRepository.getMovieDetails(query)
    }
}
