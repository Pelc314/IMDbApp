package com.example.imdbapp.domain.usecase

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.actor.KnownFor
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetKnownForUseCase @Inject constructor(
    val repository: ImdbRepository
) {
    suspend fun getKnownFor(query: String): Flow<Resource<List<KnownFor>>> {
        return repository.getKnownFor(query)
    }
}
