package com.example.imdbapp.presentation.actordetails

import com.example.imdbapp.domain.model.Actor

data class ActorDetailsState(
    val actor: Actor? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
