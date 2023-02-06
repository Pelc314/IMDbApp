package com.example.imdbapp.presentation.moviedetails

import com.example.imdbapp.domain.model.Actor
import com.example.imdbapp.domain.model.Movie
data class ActorLazyRowState(
    val actors: List<Actor>? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
