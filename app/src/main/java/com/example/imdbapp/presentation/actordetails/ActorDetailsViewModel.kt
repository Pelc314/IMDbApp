package com.example.imdbapp.presentation.actordetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.usecase.GetActorDetailsUseCase
import com.example.imdbapp.domain.usecase.GetKnownForUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActorDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getActorDetailsUseCase: GetActorDetailsUseCase,
    private val getKnownForUseCase: GetKnownForUseCase
) : ViewModel() {
    private var _actorState = mutableStateOf(ActorDetailsState())
    val actorState: State<ActorDetailsState> = _actorState
    private var _knownForState = mutableStateOf(ActorKnownForLazyColumnState())
    val knownForState: State<ActorKnownForLazyColumnState> = _knownForState

    init {
        savedStateHandle.get<String>("actorId")?.let { actorId ->
            getActorDetails(actorId)
        }
    }

    private suspend fun getKnownForMovies(actorId: String) {
        getKnownForUseCase.getKnownFor(actorId).collect() { results ->
            when (results) {
                is Resource.Success -> {
                    _knownForState.value = ActorKnownForLazyColumnState(knownFor = results.data)
                }
                is Resource.Error -> {
                    _knownForState.value =
                        ActorKnownForLazyColumnState(
                            error = results.message ?: "Unexpected error!"
                        )
                }
                is Resource.Loading -> {
                    _knownForState.value = ActorKnownForLazyColumnState(isLoading = true)
                }
            }
        }
    }

    private fun getActorDetails(actorId: String) {
        viewModelScope.launch {
            getActorDetailsUseCase.getActorDetails(actorId).collect() { results ->
                when (results) {
                    is Resource.Success -> {
                        _actorState.value = ActorDetailsState(actor = results.data)
                        getKnownForMovies(actorId)
                    }
                    is Resource.Error -> {
                        _actorState.value =
                            ActorDetailsState(error = results.message ?: "Unexpected error!")
                    }
                    is Resource.Loading -> {
                        _actorState.value = ActorDetailsState(isLoading = true)
                    }
                }
            }
        }
    }
}
