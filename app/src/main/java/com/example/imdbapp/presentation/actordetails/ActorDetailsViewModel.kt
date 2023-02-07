package com.example.imdbapp.presentation.actordetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.usecase.GetActorDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActorDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getActorDetailsUseCase: GetActorDetailsUseCase
) : ViewModel() {
    private var _state = mutableStateOf(ActorDetailsState())
    val state: State<ActorDetailsState> = _state

    init {
        savedStateHandle.get<String>("actorId")?.let { actorId ->
            getActorDetails(actorId)
        }
    }

    private fun getActorDetails(actorId: String) {
        viewModelScope.launch {
            getActorDetailsUseCase.getActorDetails(actorId).collect() { results ->
                when (results) {
                    is Resource.Success -> {
                        _state.value = ActorDetailsState(actor = results.data)
                    }
                    is Resource.Error -> {
                        _state.value =
                            ActorDetailsState(error = results.message ?: "Unexpected error!")
                    }
                    is Resource.Loading -> {
                        _state.value = ActorDetailsState(isLoading = true)
                    }
                }
            }
        }
    }
}
