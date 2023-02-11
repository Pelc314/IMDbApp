package com.example.imdbapp.presentation.mainscreenwithtopmovies

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.usecase.GetMovieDetailsUseCase
import com.example.imdbapp.domain.usecase.GetTopMovieUseCase
import com.example.imdbapp.domain.usecase.GetTopMoviesUseCase
import com.example.imdbapp.presentation.mainscreenwithtopmovies.components.MovieItemState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.* // ktlint-disable no-wildcard-imports
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetTopMoviesUseCase,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getTopRatedMovieUseCase: GetTopMovieUseCase,
) : ViewModel() {
    private var _topRatedMoviesListState = mutableStateOf(TopRatedMoviesState())
    val topRatedMoviesListState: State<TopRatedMoviesState> = _topRatedMoviesListState

//    private var _listOfStates = mutableListOf(mutableStateOf(MovieItemState()))
//    private var _listOfStates = mutableListOf<MovieItemState>()
    private var _listOfStates = mutableListOf<MutableState<MovieItemState>>()
//    val listOfMovieStates: List<MovieItemState> = _listOfStates
    val listOfMovieStates: List<State<MovieItemState>> = _listOfStates
    private val scope = CoroutineScope(Dispatchers.IO)
    private var unusuallyLongResponse: Boolean = false

    init {
        getTopRatedMovies()
    }

    fun updateState(query: String) {
        viewModelScope.launch {
            _topRatedMoviesListState.value = TopRatedMoviesState(
                topRatedMovies = _topRatedMoviesListState.value.topRatedMovies,
                searchQuery = query,
            )
        }
    }

    fun getTopRatedMovie(movieId: String, position: Int) {
        viewModelScope.launch {
            getTopRatedMovieUseCase.getTopMovie(movieId).collect() { result ->
                when (result) {
                    is Resource.Success -> {
                        _listOfStates[position].value = MovieItemState(topRatedMovieItem = result.data)
                    }
                    is Resource.Error -> {
                        _listOfStates[position].value = MovieItemState(error = result.message ?: "Unexpected error!!")
                    }
                    is Resource.Loading -> {
                        _listOfStates.add(position, mutableStateOf(MovieItemState()))
                        _listOfStates[position].value = MovieItemState(isLoading = true)
                    }
                }
            }
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            getMoviesUseCase.getTopMovies().collect() { result ->
                when (result) {
                    is Resource.Success -> {
                        _topRatedMoviesListState.value =
                            TopRatedMoviesState(topRatedMovies = result.data ?: emptyList())
                        unusuallyLongResponse = false
                    }
                    is Resource.Error -> {
                        _topRatedMoviesListState.value =
                            TopRatedMoviesState(error = result.message ?: "Unexpected Error 0_0")
                        unusuallyLongResponse = false
                    }
                    is Resource.Loading -> {
                        _topRatedMoviesListState.value = TopRatedMoviesState(isLoading = true)
                        unusuallyLongResponse = true
                        scope.launch {
                            Thread.sleep(5000L)
                            if (unusuallyLongResponse) {
                                _topRatedMoviesListState.value = TopRatedMoviesState(
                                    isLoading = true,
                                    message = "Please wait, unusually long response",
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
