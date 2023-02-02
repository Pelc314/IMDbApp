package com.example.imdbapp.presentation.SearchResults

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.usecase.GetSearchResultsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.* // ktlint-disable no-wildcard-imports
import javax.inject.Inject

@HiltViewModel
class SearchResultsViewModel @Inject constructor(
    private val getSearchResultsUseCase: GetSearchResultsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _state = mutableStateOf(SearchResultsState())
    val state: State<SearchResultsState> = _state
    private val scope = CoroutineScope(Dispatchers.IO)
    private var unusuallyLongResponse: Boolean = false

    init {
        savedStateHandle.get<String>("results")?.let { searchResults ->
            getSearchResults(searchResults)
        }
    }

    private fun getSearchResults(query: String) {
        viewModelScope.launch {
            getSearchResultsUseCase.getSearchResults(query).collect() { searchResult ->
                when (searchResult) {
                    is Resource.Success -> {
                        _state.value = SearchResultsState(
                            searchResults = searchResult.data?.results ?: emptyList()
                        )
                        unusuallyLongResponse = false
                    }
                    is Resource.Error -> {
                        _state.value =
                            SearchResultsState(
                                error = searchResult.message ?: "Unexpected Error 0_0"
                            )
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
