package com.example.imdbapp.presentation.mainscreenwithtopmovies

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.repository.ImdbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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
            repository.getTopRatedMovies().let { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { topMovies ->
                            state = state.copy(topRatedMovies = topMovies)
                        }
                    }
                    is Resource.Error -> {
//                        result.data?.let { state = state.copy() }
                    }
                    is Resource.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }
                }
            }
            Log.e("Top Rated Movies", "${repository.getTopRatedMovies().data}")
        }
    }
}
