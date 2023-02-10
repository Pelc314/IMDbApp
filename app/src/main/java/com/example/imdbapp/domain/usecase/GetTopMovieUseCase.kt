package com.example.imdbapp.domain.usecase

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.movie.TopMovie
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopMovieUseCase @Inject constructor(
    private val repository: ImdbRepository,
) {
    suspend fun getTopMovie(movieId: String): Flow<Resource<TopMovie>> {
        return repository.getTopRatedMovie(movieId)
    }
}
