package com.example.imdbapp.domain.usecase

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.actor.Actor
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActorDetailsUseCase @Inject constructor(
    val repository: ImdbRepository
) {
    suspend fun getActorDetails(actorId: String): Flow<Resource<Actor>> {
        return repository.getActorDetails(actorId)
    }
}
