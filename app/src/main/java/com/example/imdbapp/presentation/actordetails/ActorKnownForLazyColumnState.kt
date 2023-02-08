package com.example.imdbapp.presentation.actordetails

import com.example.imdbapp.domain.model.actor.KnownFor

data class ActorKnownForLazyColumnState(
    val knownFor: List<KnownFor>? = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
