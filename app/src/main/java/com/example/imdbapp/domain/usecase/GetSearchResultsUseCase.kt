package com.example.imdbapp.domain.usecase

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.TopMovie
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchResultsUseCase @Inject constructor(
    private val repository: ImdbRepository
) {
    suspend fun getSearchResults(): Flow<Resource<List<SearchResults>>> {
        return repository.getSearchResults()
    }
}