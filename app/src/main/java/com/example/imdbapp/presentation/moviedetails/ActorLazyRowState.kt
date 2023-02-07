package com.example.imdbapp.presentation.moviedetails

data class ActorLazyRowState(
    val actors: List<String>? = emptyList(),
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
