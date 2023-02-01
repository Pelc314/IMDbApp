package com.example.imdbapp.presentation.SearchResults

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.usecase.GetMovieDetailsUseCase
import com.example.imdbapp.domain.usecase.GetTopMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.* // ktlint-disable no-wildcard-imports
import javax.inject.Inject

@HiltViewModel
class SearchResultsViewModel @Inject constructor(
    private val getMoviesUseCase: GetTopMoviesUseCase,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {
    private var _state = mutableStateOf(SearchResultsState())
    val state: State<SearchResultsState> = _state
    private val scope = CoroutineScope(Dispatchers.IO)
    private var unusuallyLongResponse: Boolean = false

    init {
        getTopRatedMovies()
    }
    fun updateState(query: String) {
        viewModelScope.launch {
            _state.value = SearchResultsState(topRatedMovies = _state.value.topRatedMovies, searchQuery = query)
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            getMoviesUseCase.getTopMovies().collect() { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value =
                            SearchResultsState(topRatedMovies = result.data ?: emptyList())
                        unusuallyLongResponse = false
                    }
                    is Resource.Error -> {
                        _state.value =
                            SearchResultsState(error = result.message ?: "Unexpected Error 0_0")
                        unusuallyLongResponse = false
                    }
                    is Resource.Loading -> {
                        _state.value = SearchResultsState(isLoading = true)
                        unusuallyLongResponse = true
                        scope.launch {
                            Thread.sleep(5000L)
                            if (unusuallyLongResponse) {
                                _state.value = SearchResultsState(
                                    isLoading = true,
                                    message = "Please wait, unusually long response"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
