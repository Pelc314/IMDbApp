package com.example.imdbapp.presentation.mainscreenwithtopmovies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.usecase.gettopmovies.GetTopMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetTopMoviesUseCase
) : ViewModel() {
    private var _state = mutableStateOf(TopRatedMoviesState())
    val state: State<TopRatedMoviesState> = _state

    init {
        getTopRatedMovies()
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            getMoviesUseCase.getTopMovies().collect() { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value =
                            TopRatedMoviesState(topRatedMovies = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value =
                            TopRatedMoviesState(error = result.message ?: "Unexpected Error 0_0")
                    }
                    is Resource.Loading -> {
                        _state.value = TopRatedMoviesState(isLoading = true)
                    }
                }
            }
        }
    }
}
