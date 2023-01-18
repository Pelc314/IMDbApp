package com.example.imdbapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.domain.repository.ImdbRepository
import com.example.imdbapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(
    private val repository: ImdbRepository
) : ViewModel() {
    var state by mutableStateOf(TopRatedMoviesState())

    init {
        getTopRatedMovies()
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            repository.getTopRatedMovies().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { topMoviesList ->
                            state = state.copy(topRatedMovies = topMoviesList)
                        }
                    }
                    is Resource.Error -> Unit
                    is Resource.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }
                }
            }
        }
    }
}
