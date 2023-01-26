package com.example.imdbapp.domain.usecase.getmovies

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.TopMovie
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: ImdbRepository
) {
    suspend fun getTopMovies(): Flow<Resource<List<TopMovie>>> {
        return repository.getTopRatedMovies()
    }
}
