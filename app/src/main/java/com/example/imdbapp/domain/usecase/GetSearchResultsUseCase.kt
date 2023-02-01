package com.example.imdbapp.domain.usecase

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.SearchResults
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchResultsUseCase @Inject constructor(
    private val repository: ImdbRepository
) {
    suspend fun getSearchResults(query: String): Flow<Resource<SearchResults>> {
        return repository.getSearchResults(query)
    }
}
