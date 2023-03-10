package com.example.imdbapp.presentation.actordetails

import com.example.imdbapp.domain.model.actor.Actor

data class ActorDetailsState(
    val actor: Actor? = null,
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
