package com.example.imdbapp.domain.repository

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.actor.Actor
import com.example.imdbapp.domain.model.actor.KnownFor
import com.example.imdbapp.domain.model.movie.Movie
import com.example.imdbapp.domain.model.movie.TopMovie
import com.example.imdbapp.domain.model.searchresults.SearchResults
import kotlinx.coroutines.flow.Flow

interface ImdbRepository {
    suspend fun getTopRatedMovies(): Flow<Resource<List<TopMovie>>>
    suspend fun getTopRatedMovie(movieId: String): Flow<Resource<TopMovie>>
    suspend fun getKnownFor(query: String): Flow<Resource<List<KnownFor>>>
    suspend fun getMovieDetails(query: String): Flow<Resource<Movie>>
    suspend fun getActor(query: String): Flow<Resource<Actor>>
    suspend fun getActorDetails(query: String): Flow<Resource<Actor>>
    suspend fun getSearchResults(query: String): Flow<Resource<SearchResults>>
}
