package com.example.imdbapp.presentation.moviedetails

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.usecase.GetActorDetailsUseCase
import com.example.imdbapp.domain.usecase.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getActorDetailsUseCase: GetActorDetailsUseCase,
) : ViewModel() {
    private var _stateMovieDetails = mutableStateOf(MovieDetailsState())
    val movieState: State<MovieDetailsState> = _stateMovieDetails
    private var _stateActorsRow = mutableStateOf(ActorLazyRowState())
    val actorsLazyRowState: State<ActorLazyRowState> = _stateActorsRow

    init {
        savedStateHandle.get<String>("movieId")?.let { movieId ->
            getMovieDetails(movieId)
        }
    }

/*    private fun getActorImage(actorId: String) {
        viewModelScope.launch() {
            getActorDetailsUseCase.getActorDetails(actorId).collect() { details ->
                when (details) {
                    is Resource.Success -> {
                        _stateActorsRow.value = MovieDetailsState(actor = details.=)
                    }
                    is Resource.Error -> {
                        _stateActorsRow.value =
                            ActorLazyRowState(error = details.message ?: "Unknown error!")

                    }
                    is Resource.Loading -> {
                        ActorLazyRowState(isLoading = true)
                    }
                }
            }
        }
    }*/

    private fun getMovieDetails(movieId: String) {
        viewModelScope.launch {
            getMovieDetailsUseCase.getMovieDetails(movieId).collect() { results ->
                Log.d("results", "${results.message}")
                when (results) {
                    is Resource.Success -> {
                        _stateMovieDetails.value = MovieDetailsState(movie = results.data)
                    }
                    is Resource.Error -> {
                        _stateMovieDetails.value =
                            MovieDetailsState(error = results.message ?: "Unexpected error!")
                    }
                    is Resource.Loading -> {
                        _stateMovieDetails.value = MovieDetailsState(isLoading = true)
                    }
                }
            }
        }
    }
}
