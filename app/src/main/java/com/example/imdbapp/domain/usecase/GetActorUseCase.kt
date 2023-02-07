package com.example.imdbapp.domain.usecase

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.Actor
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActorUseCase @Inject constructor(
    val repository: ImdbRepository
) {
    suspend fun getActor(actorId: String): Flow<Resource<Actor>> {
        return repository.getActor(actorId)
    }
}
